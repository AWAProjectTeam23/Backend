package com.example.restapi.api;

import java.util.List;
import java.util.Map;

import com.example.restapi.models.Menu;
import com.example.restapi.repos.MenuRepo;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService webService;

    @Autowired
    private MenuRepo menuRepo;

    @GetMapping("/")
    public ResponseEntity<?> RestaurantListing() {
        var result = webService.getRestaurants();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/menu")
    public ResponseEntity<?> MenuListing() {
        var resp = webService.getMenu();
        return ResponseEntity.ok(resp);
    }
    @GetMapping("/category")
    public ResponseEntity<?> CategryListing() {
        var resp = webService.getFromCategory();
        return ResponseEntity.ok(resp);
    }
    
    
}
