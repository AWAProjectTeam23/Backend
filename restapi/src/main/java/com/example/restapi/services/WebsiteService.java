package com.example.restapi.services;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;
import com.example.restapi.repos.OrdersRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteService implements IWebsiteService{

    private List<RestaurantInfo> restaurantinfo;
    private List<Orders> customerOrders;

    @Autowired
    private RestaurantInfoRepo restaurantInfoRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Override
    public List<RestaurantInfo> getRestaurants() {
        restaurantinfo = restaurantInfoRepo.findAll();
        return restaurantinfo;
    }

    @Override
    public List<Orders> allCustomerOrders() {
        customerOrders = ordersRepo.findByOrderNcustomerId();
        return customerOrders;
    }
}
