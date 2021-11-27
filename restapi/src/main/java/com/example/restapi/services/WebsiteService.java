package com.example.restapi.services;

import com.example.restapi.models.*;
import com.example.restapi.repos.OrdersRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WebsiteService implements IWebsiteService{


    @Autowired
    private RestaurantInfoRepo restaurantInfoRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        return restaurantInfoRepo.findAll();
    }

    @Override
    public List<Orders> allCustomerOrders(UUID customerID) {
        return ordersRepo.findCustomerOrders(customerID);
    }

    @Override
    public List<Orders> allManagerOrders(UUID id) {
        return ordersRepo.findManagerOrders(id);
    }
}
