package com.example.restapi.services;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.example.restapi.models.ProductTable;
import com.example.restapi.models.RestaurantInfo;

import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.ListSelectionModel;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();
    List<Menu> getMenu();
    List<Category> getCategory();
    
    List<?> getMenuWithParm(UUID id);
    //List<ProductTable> getItemID();
    //List<ProductTable> getIdByName(String productName);
    //boolean addProductToMenu(Map<String, String> body);
    boolean addNewCategory(Map<String, String> body);
    boolean addMenuToResta(Map<String, String>body);
    //boolean addMenuItemsListTo(Map<String, String>body);
    //boolean addNewProductToCat(Map<String, String>body);
    boolean addingProductsToMenu(Map<String, String>body);
   // void asdasd();
}
