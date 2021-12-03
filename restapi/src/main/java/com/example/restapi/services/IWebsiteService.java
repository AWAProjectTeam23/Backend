package com.example.restapi.services;

import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface IWebsiteService {
    List<Menu> getMenu();
    List<Category> getCategory();
    List<?> getMenuWithParm(UUID id);
    
   
    boolean addNewCategory(Map<String, String> body);
    boolean addMenuToResta(Map<String, String>body);
    boolean addNewProduct(Map<String, String> body);
   
}
