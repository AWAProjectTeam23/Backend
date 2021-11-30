package com.example.restapi.services;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;

import java.sql.Time;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();

    List<?> allCustomerOrders(UUID id);

    List<?> allManagerOrders(UUID id);

    void updateOrderStatus(Integer orderStatusCode, UUID order_id);

    boolean storeRestaurantInfo(Map<String, String> body);

    boolean storeAccountInfo(Map<String, String> body);

    List<?> getUsers();
}
