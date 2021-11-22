package com.example.restapi.services;

import com.example.restapi.models.Menu;
import com.example.restapi.models.RestaurantInfo;

import java.util.List;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();
    List<Menu> getMenu();
    //List<Menu> getFromCategory();
}
