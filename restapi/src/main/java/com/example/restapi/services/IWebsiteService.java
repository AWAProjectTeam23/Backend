package com.example.restapi.services;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.example.restapi.models.RestaurantInfo;

import java.util.List;
import java.util.UUID;

import javax.swing.ListSelectionModel;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();
    List<Menu> getMenu();
    List<Menu> getMenuWithParm(UUID id);
   
}
