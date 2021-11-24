package com.example.restapi.services;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;

import java.util.List;

public interface IWebsiteService {
    List<RestaurantInfo> getRestaurants();

    List<Orders> allCustomerOrders();
}
