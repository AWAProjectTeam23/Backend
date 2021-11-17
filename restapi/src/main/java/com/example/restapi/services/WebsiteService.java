package com.example.restapi.services;

import com.example.restapi.models.RestaurantInfo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class WebsiteService implements IWebsiteService{

    private List<RestaurantInfo> restaurantinfo;

    @Autowired
    private RestaurantInfoRepo RestaurantInfoRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        restaurantinfo = RestaurantInfoRepo.getRestaurantInfo();
        return restaurantinfo;
    }
}
