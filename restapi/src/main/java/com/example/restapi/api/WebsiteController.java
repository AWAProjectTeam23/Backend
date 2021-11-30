package com.example.restapi.api;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.models.UserInfo;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.security.PasswordEncoder;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.util.Map;
import java.util.UUID;

@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService webService;

    @Autowired
    UserRepo userRepo;


    @GetMapping("/admin")
    public ResponseEntity<?> adminTestPage() {
        String adminpage = "admin page";
        return ResponseEntity.ok(adminpage);
    }

    @GetMapping("/customer")
    public ResponseEntity<?> customerTestPage() {

        //USER INFORMATION
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        String adminpage = "customer page";
        return ResponseEntity.ok(adminpage+username);
    }

    @GetMapping("/public")
    public ResponseEntity<?> RestaurantListing() {
        var result = webService.getRestaurants();
        var ersrsr = webService.getUsers();
        return ResponseEntity.ok(ersrsr);
    }

    @GetMapping("/customer/OrderHistory/{id}")
    public ResponseEntity<?> CustomerOrderHistory(@PathVariable UUID id) {
        var customerOrders = webService.allCustomerOrders(id);
        return ResponseEntity.ok(customerOrders);
    }

    @GetMapping("/manager/OrderHistory/{restaurant_id}")
    public ResponseEntity<?> ManagerOrderHistory(@PathVariable UUID restaurant_id) {
        var managerOrders = webService.allManagerOrders(restaurant_id);
        return ResponseEntity.ok(managerOrders);
    }

    @PostMapping("/Manager/Orders")
    public ResponseEntity<?> UpdateOrderStatus(@RequestBody Map<String, String> body) {
        var order_id = UUID.fromString(body.get("order_id"));
        var newOrderStatus = Integer.parseInt(body.get("orderStatusCode"));
        webService.updateOrderStatus(newOrderStatus, order_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/Manager/CreateRestaurant")
    public ResponseEntity<?> CreateRestaurant(@RequestBody Map<String, String> body) {
        if(body == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid restaurantinformation" + body);
        }

        var success = webService.storeRestaurantInfo(body);

        if(!success) {
            return ResponseEntity.badRequest()
                    .body("Failed to create a new restaurant:" + body.get("restaurantname"));
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/public/CreateAccount")
    public ResponseEntity<?> CreateAccount(@RequestBody Map<String, String> body) {
        if(body == null) {
            return ResponseEntity.badRequest()
                    .body("Invalid accountInfo" + body);
        }

        var success = webService.storeAccountInfo(body);

        if(!success) {
            return ResponseEntity.badRequest()
                    .body("Failed to create a new account:" + body.get("username"));
        }

        return ResponseEntity.ok().build();
    }
}
