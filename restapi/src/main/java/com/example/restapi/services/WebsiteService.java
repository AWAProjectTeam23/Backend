package com.example.restapi.services;

import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.logging.Logger;

@Service
public class WebsiteService implements IWebsiteService{

    private List<RestaurantInfo> restaurantinfo;

    @Autowired
    private RestaurantInfoRepo restaurantInfoRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        restaurantinfo = restaurantInfoRepo.getRestaurantInfo();
        return restaurantinfo;
    }
}
