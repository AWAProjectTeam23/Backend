package com.example.restapi.services;

import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.repos.MenuRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class WebsiteService implements IWebsiteService{

    private List<RestaurantInfo> restaurantinfo;
    private List<Menu> menu;
    private List<Category> bs;

    @Autowired
    private RestaurantInfoRepo RestaurantInfoRepo;

    @Autowired
    private MenuRepo MenuRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        restaurantinfo = RestaurantInfoRepo.getRestaurantInfo();
        return restaurantinfo;
    }

    @Override
        public List<Menu> getMenu(){
        menu = MenuRepo.getMenuInfo();
        return menu;
    }


    
    @Override
        public List<Category> getFromCategory(){
        bs =  MenuRepo.getCategoryInfo();
        return bs;
    }
    
}
