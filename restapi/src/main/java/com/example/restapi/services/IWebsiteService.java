package com.example.restapi.services;

import com.example.restapi.models.NewOrders;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.models.RestaurantModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();

    List<?> getRestaurantsOfManager(UUID id);

    boolean storeOrderInfo(NewOrders body);

    List<?> allCustomerOrders(UUID id);

    List<?> allManagerOrders(UUID id);

    boolean updateOrderStatus(Map<String, String> body);

    boolean storeRestaurantInfo(RestaurantModel model, String imageURL);

    boolean storeAccountInfo(Map<String, String> body);

    List<?> getUsers();
}
