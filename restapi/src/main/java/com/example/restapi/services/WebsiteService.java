package com.example.restapi.services;

import com.example.restapi.models.*;
import com.example.restapi.repos.OrdersRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.security.PasswordEncoder;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;

@Service
public class WebsiteService implements IWebsiteService{


    @Autowired
    private RestaurantInfoRepo restaurantInfoRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    PasswordEncoder pwEncoder;

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

    @Override
    public void updateOrderStatus(Integer orderStatusCode, UUID order_id) {
        ordersRepo.updateOrderStatus(orderStatusCode, order_id);
    }

    @Override
    public boolean storeRestaurantInfo(Map<String, String> body)
    {
        var name = body.get("restaurantname");
        var address = body.get("address");
        var open = Time.valueOf(body.get("open_hour"));
        var closing = Time.valueOf(body.get("closing_hour"));
        var image = body.get("imageURL");
        var type = body.get("restauranttype");
        var priceLevel = Integer.parseInt(body.get("pricelevel"));
        var manager_id = UUID.fromString(body.get("user_id"));

        try {
            restaurantInfoRepo.insertNewRestaurant(name, address, open, closing, image, type, priceLevel, manager_id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean storeAccountInfo(Map<String, String> body) {
        var username = body.get("username");
        var password = pwEncoder.encode(body.get("password"));
        var role = body.get("role");

        try {
            userRepo.insertNewAccount(username, password, role);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<?> getUsers() {
        return userRepo.findAll();
    }
}
