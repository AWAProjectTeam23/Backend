package com.example.restapi.api;

import java.util.Map;
import java.util.UUID;
import com.example.restapi.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService webService;


    //Some mappingfor extra information
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






   //Get menus with restaurant UUID 
   @GetMapping("/menus/{id}")
   public ResponseEntity<?> MenuWithParam(@PathVariable UUID id) {
       var resp = webService.getMenuWithParm(id);
       return ResponseEntity.ok(resp);
   }


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
        .body("Oops something went wrong!!!");
    }
       return ResponseEntity.ok().build();
    
    
    }



   //For creating a new restaurant menu
   @PostMapping("/Manager/createMenu")
   public ResponseEntity<?> addingNewMenu(@RequestBody Map<String, String> body){
        if(body == null) {
            return ResponseEntity.badRequest()
            .body("No valid information");   
        }
        
        var success  = webService.addMenuToResta(body);

        if(!success) {
            return ResponseEntity.badRequest()
            .body("Oops something went wrong!!!");
        }
        
        return ResponseEntity.ok().build();

    
    }
    
    //For adding a new product to menu 
    @PostMapping("/Manager/addNewProduct")
    public ResponseEntity<?> addNewProduct(@RequestBody Map<String, String> body ){
        if(body == null) {
            return ResponseEntity.badRequest()
            .body("Not valid data");
        }
        
        var success = webService.addNewProduct(body);

        if(!success) {
            return ResponseEntity.badRequest()
            .body("Oops something went wrong!!!");
        }
        return ResponseEntity.ok().build();
    }

}
