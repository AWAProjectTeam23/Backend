package com.example.restapi.api;

import com.example.restapi.models.Orders;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService webService;

    @GetMapping("/")
    public ResponseEntity<?> RestaurantListing() {
        var result = webService.getRestaurants();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/OrderHistory")
    public ResponseEntity<?> CustomerOrderHistory() {
        List<Orders> result = webService.allCustomerOrders();
        return ResponseEntity.ok(result);
    }
}
