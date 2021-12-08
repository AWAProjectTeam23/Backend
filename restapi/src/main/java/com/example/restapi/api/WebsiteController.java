package com.example.restapi.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.restapi.models.*;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.security.PasswordEncoder;
import java.util.Map;
import java.util.UUID;
import com.example.restapi.services.WebsiteService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.Time;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsiteController {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dpsxvybq0",
                    "api_key", "167478827989582",
                    "api_secret", "N-7PXIcpwO9HUkbu2mIDnJaefCs"
    ));

    @Autowired
    private WebsiteService webService;

    @GetMapping("/admin")
    public ResponseEntity<?> adminTestPage() {
        String adminpage = "admin page";
        return ResponseEntity.ok(adminpage);
    }

    @GetMapping("/customer")
    public ResponseEntity<?> customerTestPage() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String adminpage = "customer page";
        return ResponseEntity.ok(adminpage+username);
    }

    @GetMapping("/public")
    public ResponseEntity<?> RestaurantListing() {
        var result = webService.getRestaurants();
        if(result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/public/CreateAccount")
    public ResponseEntity<?> CreateAccount(@RequestBody Map<String, String> body) {
        if(body == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid accountInfo");
        }
        var success = webService.storeAccountInfo(body);
        if(!success) {
            return ResponseEntity.badRequest()
                    .body("Failed to create a new account:" + body.get("username"));
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customer/ShoppingCart")
    public ResponseEntity<?> StoreCustomerOrder(@RequestBody NewOrders model) {
        if(model == null) {
            ResponseEntity.badRequest().body("Cannot be null");
        }
        var result = webService.storeOrderInfo(model);
        if(result == false) {
            return ResponseEntity.badRequest().body("Couldn't place order");
        }
        return ResponseEntity.ok().build();
    }

    @JsonView(View.OrdersWithRestaurantName.class)
    @GetMapping("/customer/OrderHistory")
    public ResponseEntity<?> CustomerOrderHistory() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID id = UUID.fromString(webService.getUserID(username));
        if(id == null) {
            return ResponseEntity.badRequest().body("Given ID cannot be null");
        }
        var customerOrders = webService.allCustomerOrders(id);
        if(customerOrders == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerOrders);
    }

    @JsonView(View.OrdersWithRestaurantName.class)
    @GetMapping("/customer/OrderStatus")
    public ResponseEntity<?> CustomerOrdersStatus() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID id = UUID.fromString(webService.getUserID(username));
        if(id == null) {
            return ResponseEntity.badRequest().body("Customer ID cannot be null");
        }
        var customerOrderStatusList = webService.allCustomerOrders(id);

        if(customerOrderStatusList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerOrderStatusList);
    }

    @GetMapping("/manager/restaurants")
    public ResponseEntity<?> ManagerRestaurants() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID manager_id = UUID.fromString(webService.getUserID(username));
        if(manager_id == null) {
            return ResponseEntity.badRequest().body("Manager ID cannot be null");
        }
        var response = webService.getRestaurantsOfManager(manager_id);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @JsonView(View.OrdersWithCustomerName.class)
    @GetMapping("/manager/OrderHistory/{restaurant_id}")
    public ResponseEntity<?> ManagerOrderHistory(@PathVariable UUID restaurant_id) {
        if(restaurant_id == null) {
            return ResponseEntity.badRequest().body("Restaurant ID cannot be null");
        }
        var managerOrders = webService.allManagerOrders(restaurant_id);
        if(managerOrders == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(managerOrders);
    }

    @JsonView(View.OrdersWithCustomerName.class)
    @GetMapping("/manager/OrderStatus")
    public ResponseEntity<?> ManagerOrdersStatus() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID manager_id = UUID.fromString(webService.getUserID(username));
        if(manager_id == null) {
            return ResponseEntity.badRequest().body("Manager ID cannot be null");
        }
        var managerOrderStatusList = webService.allManagerOrders(manager_id);
        if(managerOrderStatusList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(managerOrderStatusList);
    }

    @PostMapping("/manager/Orders")
    public ResponseEntity<?> OrderReceived(@RequestBody Map<String, String> body) {
        if(body == null) {
            return ResponseEntity.badRequest().body("RequestBody cannot be null");
        }
        if(webService.updateOrderStatus(body) == false) {
            return ResponseEntity.internalServerError().body("Could not update order status in DB");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/manager/CreateRestaurant")
    public ResponseEntity<?> CreateRestaurant(@ModelAttribute RestaurantModel model) {
        String imageUrl = "";
        if(model == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid restaurant information");
        }
        try {
            Map map = cloudinary.uploader().upload(model.getImage().getBytes(), ObjectUtils.emptyMap());
            imageUrl = (String) map.get("url");

        } catch (IOException e) {
            e.printStackTrace();
        }
        var success = webService.storeRestaurantInfo(model, imageUrl);
        if(!success) {
            return ResponseEntity.badRequest()
                    .body("Failed to create a new restaurant:" + model.getRestaurantName());
        }
        return ResponseEntity.ok().build();
    }

   //Get menus with restaurant UUID 
   @GetMapping("/public/menus/{restaurant_id}")
   public ResponseEntity<?> MenuWithParam(@PathVariable UUID restaurant_id) {
       var resp = webService.getMenuWithParm(restaurant_id);
       return ResponseEntity.ok(resp);
   }

   //For creating a new category
   @PostMapping("/manager/addCategory")
   public ResponseEntity<?>  addingNewCategory(@RequestBody Map<String, String> body) {
       if(body == null ) {
           return ResponseEntity.badRequest()
           .body("No valid information");
       }
       var success = webService.addNewCategory(body);

    if(!success) {
       return ResponseEntity.badRequest()
        .body("Oops something went wrong!!!");
    }
       return ResponseEntity.ok().build();
    }
    
    //For adding a new product to menu 
    @PostMapping("/manager/addNewProduct")
    public ResponseEntity<?> addNewProduct(@ModelAttribute ProductModel model){
        String imageUrl = "";
        if(model == null) {
            return ResponseEntity.badRequest()
            .body("Not valid data");
        }

        try {
            Map map = cloudinary.uploader().upload(model.getImage().getBytes(), ObjectUtils.emptyMap());
            imageUrl = (String) map.get("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        var success = webService.addNewProduct(model, imageUrl);

        if(!success) {
            return ResponseEntity.badRequest()
            .body("Oops something went wrong!!!");
        }
        return ResponseEntity.ok().build();
    }
}
