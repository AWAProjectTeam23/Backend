package com.example.restapi.services;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.example.restapi.models.ProductTable;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.repos.CategoryRepo;
import com.example.restapi.repos.MenuRepo;
import com.example.restapi.repos.ProductTableRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.fasterxml.jackson.databind.JsonNode;

import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.tokens.ValueToken;

import javax.management.relation.Role;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WebsiteService implements IWebsiteService{

    private List<RestaurantInfo> restaurantinfo;
    private List<Menu> menu;
    private List<Category> cat;
    //private List<Menu> getMenuByParam;

    
    @Autowired
    private ProductTableRepo productTableRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private RestaurantInfoRepo RestaurantInfoRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        restaurantinfo = RestaurantInfoRepo.getRestaurantInfo();
        return restaurantinfo;
    }
 
    @Override
    public List<Category> getCategory() {
        cat = categoryRepo.getAllFromCat();
        return cat;
    }
 
    @Override
        public List<Menu> getMenu(){
        menu = menuRepo.getMenuInfo();
        return menu;
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
   public boolean addNewProduct(Map<String, String>body) {
       var productName = body.get("productName");
       var price = body.get("price");
       var imageurl = body.get("imageurl");
       var product_description = body.get("product_description");
       var category_id = UUID.fromString(body.get("category_id"));

       try {
           productTableRepo.insertNewProduct(productName, price, imageurl, product_description, category_id);
       } catch (Exception e) {
           return false;
       }
       return true;

   }

}
