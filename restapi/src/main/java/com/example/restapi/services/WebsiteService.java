package com.example.restapi.services;

import com.example.restapi.models.*;
import com.example.restapi.repos.OrdersRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.repos.CategoryRepo;
import com.example.restapi.repos.MenuRepo;
import com.example.restapi.repos.ProductTableRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WebsiteService implements IWebsiteService{
  
    @Autowired
    private ProductTableRepo productTableRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private RestaurantInfoRepo restaurantInfoRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private UserRepo userRepo;
  
    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    PasswordEncoder pwEncoder;

    public String getUserID(String username ) {
        return userRepo.getUserID(username);
    }

    @Override
    public List<RestaurantInfo> getRestaurants() { return restaurantInfoRepo.findAll(); }

    @Override
    public List<?> getRestaurantsOfManager(UUID manager_id) {
        var restaurantsOfManager = restaurantInfoRepo.findAll()
                .stream()
                .filter(r -> r.getRestaurantManagerUserId().equals(manager_id))
                .collect(Collectors.toList());

        return restaurantsOfManager;
    }

    @Override
    public boolean storeOrderInfo(NewOrders body) {
        var order_id = ordersRepo.insertOrder(UUID.fromString(body.getCustomer_uuid()),
                UUID.fromString(body.getRestaurant_uuid()),
                body.getTotalPrice(),
                body.getDelivery_location());
        var orderProducts = body.getOrderProducts();
        for (int i = 0; i < orderProducts.size(); i++) {
            var product_id = orderProducts.get(i).getProduct_uuid();
            var productQuantity = orderProducts.get(i).getProductQuantity();
            try {
                ordersRepo.insertOrderProducts(order_id, UUID.fromString(product_id), productQuantity);
            } catch (Exception e) {
                ordersRepo.deleteById(order_id.toString());
                return false;
            }
        }
        return true;
    }


    @Override
    public List<Orders> allCustomerOrders(UUID customerID) {
        return ordersRepo.findCustomerOrders(customerID);
    }

    @Override
    public List<Orders> allManagerOrders(UUID id) {
        return ordersRepo.findManagerOrders(id);
    }

    @Override
    public boolean updateOrderStatus(Map<String, String> body) {
        try {
            ordersRepo.updateOrderStatus(Integer.parseInt(body.get("orderStatusCode")),
                                        UUID.fromString(body.get("order_id")));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean storeRestaurantInfo(RestaurantModel model, String imageURL)
    {
        var name = model.getRestaurantName();
        var address = model.getAddress();
        var open = Time.valueOf(model.getOpen_hour());
        var closing = Time.valueOf(model.getClosing_hour());
        var type = model.getStyle();
        var priceLevel = Integer.parseInt(model.getPriceLevel());
        var manager_id = UUID.fromString(model.getManager_id());

        try {
            restaurantInfoRepo.insertNewRestaurant(name, address, open, closing, imageURL, type, priceLevel, manager_id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean storeAccountInfo(Map<String, String> body) {
        var username = body.get("username");
        var password = body.get("password");
        var role = body.get("role");
        if(password == "" || username == "" || role == "") {
            return false;
        }
        try {
            userRepo.insertNewAccount(username, pwEncoder.encode(password), role);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

//Get menu with restaurant UUID  
    @Override
    public List<Menu> getMenuWithParm(UUID id) {
        return menuRepo.getMenuById(id);
    }

//New restaurant menu
    @Override
    public boolean addMenuToResta(Map<String, String> body) {

        var menuName = body.get("menuName");
        var restaurant_id = UUID.fromString(body.get("restaurant_id"));
        try {
            menuRepo.addMenuToRestaurant(menuName, restaurant_id);
        } catch (Exception e) {
        return false;
        }
        return true;
    }
  
//Add new category
     @Override
     public boolean addNewCategory(Map<String, String> body) {
         var categoryName = body.get("categoryName");
         var menu_id= UUID.fromString(body.get("menu_id"));
         try {
             categoryRepo.addNewCategory(categoryName, menu_id);
         } catch (Exception e) {
             return false;
         }
         return true;
     }
   
   //Create new menu item
   @Override
   public boolean addNewProduct(ProductModel body, String imageUrl) {
       try {
           productTableRepo.insertNewProduct(body.getProductName(), body.getPrice(), imageUrl,
                   body.getProduct_description(), UUID.fromString(body.getCategory_uuid()));
       } catch (Exception e) {
           return false;
       }
       return true;
   }
}
