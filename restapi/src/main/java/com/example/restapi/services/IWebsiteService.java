package com.example.restapi.services;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();

    List<?> allCustomerOrders(UUID id);

    List<?> allManagerOrders(UUID id);
}
