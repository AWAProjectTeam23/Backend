package com.example.restapi.api;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Menu;
import com.example.restapi.repos.MenuRepo;
import com.example.restapi.services.WebsiteService;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.zaxxer.hikari.util.SuspendResumeLock;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.MAX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;

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
    @GetMapping("/allCat")
    public ResponseEntity<?> CatListing(){
        var result = webService.getCategory();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/menu")
    public ResponseEntity<?> MenuListing() {
        var resp = webService.getMenu();
        return ResponseEntity.ok(resp);
    }
   @GetMapping("/menus/{id}")
   public ResponseEntity<?> MenuWithParam(@PathVariable UUID id) {
       var resp = webService.getMenuWithParm(id);
       return ResponseEntity.ok(resp);
   }
    
   /*@PostMapping("/Manager/addProducts")
   public ResponseEntity<?> addProducts(@RequestBody Map<String, String> body){
        if(body == null) {
            return ResponseEntity.badRequest()
            .body("Check your information");

        }

        var working = webService.addProductToMenu(body);

        if(!working) {
            return ResponseEntity.badRequest()
            .body("FAiled to add new product");
        }

        return ResponseEntity.ok().build();
   }*/ 

   //For creating a new category
   @PostMapping("/Manager/addCategory")
   public ResponseEntity<?>  addingNewCategory(@RequestBody Map<String, String> body) {
       if(body == null ) {
           return ResponseEntity.badRequest()
           .body("No valid information");
       }
       var success = webService.addNewCategory(body);

    if(!success) {
       return ResponseEntity.badRequest()
        .body("Not Working?????!!!");
    }
       return ResponseEntity.ok().build();
    
    
    }



   //For creating a new restaurant menu
   @PostMapping("/Manager/createMenu")
   public ResponseEntity<?> addingNewMenu(@RequestBody Map<String, String> body){
        if(body == null) {
            return ResponseEntity.badRequest()
            .body("Not valid information");   
        }
        
        var success  = webService.addMenuToResta(body);

        if(!success) {
            return ResponseEntity.badRequest()
            .body("Check your data");
        }
        
        return ResponseEntity.ok().build();

    
    }
    
    //Adding products to db with two repos
    @PostMapping("/Manager/addProducts")
    public ResponseEntity<?> addingProductsToDb(@RequestBody Map<String, String> body) {
        if(body == null) {
            return ResponseEntity.badRequest()
            .body("Check your data");
        }

        var success = webService.addingProductsToMenu(body);

        if(!success) {
            return ResponseEntity.badRequest()
            .body("Oops! something went wrong");
        }

        return ResponseEntity.ok().build();
    }

}
