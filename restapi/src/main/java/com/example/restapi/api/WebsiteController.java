package com.example.restapi.api;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService webService;

    @GetMapping("/")
    public ResponseEntity<?> RestaurantListing() {
        var result = webService.getRestaurants();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/OrderHistory/{id}")
    public ResponseEntity<?> CustomerOrderHistory(@PathVariable UUID id) {
        var customerOrders = webService.allCustomerOrders(id);
        return ResponseEntity.ok(customerOrders);
    }

    @GetMapping("/ManagerOrderHistory/{restaurant_id}")
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
}
