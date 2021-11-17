package com.example.restapi.services;

import com.example.restapi.models.RestaurantInfo;
import com.fasterxml.jackson.databind.JsonNode;

import javax.management.relation.Role;
import java.util.List;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();
}
