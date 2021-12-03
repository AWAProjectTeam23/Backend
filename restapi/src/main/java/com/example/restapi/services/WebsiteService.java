package com.example.restapi.services;

import com.example.restapi.models.*;
import com.example.restapi.repos.OrdersRepo;
import com.example.restapi.repos.RestaurantInfoRepo;
import com.example.restapi.repos.UserRepo;
import com.example.restapi.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<RestaurantInfo> getRestaurants() { return restaurantInfoRepo.findAll(); }

    @Override
    public List<?> getRestaurantsOfManager(UUID manager_id) {
        var restaurantsOfManager = restaurantInfoRepo.findAll()
                .stream()
                .filter(r -> r.getRestaurantManagerUserId().equals(manager_id))
                .collect(Collectors.toList());

        return restaurantsOfManager;
    }

    @Override
    public boolean storeOrderInfo(NewOrders body) {
        var order_id = ordersRepo.insertOrder(UUID.fromString(body.getCustomer_uuid()),
                UUID.fromString(body.getRestaurant_uuid()),
                body.getTotalPrice());
        var orderProducts = body.getOrderProducts();
        for (int i = 0; i < orderProducts.size(); i++) {
            var product_id = orderProducts.get(i).getProduct_uuid();
            var productQuantity = orderProducts.get(i).getProductQuantity();
            try {
                ordersRepo.insertOrderProducts(order_id, UUID.fromString(product_id), productQuantity);
            } catch (Exception e) {
                ordersRepo.deleteById(order_id.toString());
                return false;
            }
        }
        return true;
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
    public boolean updateOrderStatus(Map<String, String> body) {
        try {
            ordersRepo.updateOrderStatus(Integer.parseInt(body.get("orderStatusCode")),
                                        UUID.fromString(body.get("order_id")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean storeRestaurantInfo(RestaurantModel model, String imageURL)
    {
        var name = model.getRestaurantName();
        var address = model.getAddress();
        var open = Time.valueOf(model.getOpen_hour());
        var closing = Time.valueOf(model.getClosing_hour());
        var type = model.getStyle();
        var priceLevel = Integer.parseInt(model.getPriceLevel());
        var manager_id = UUID.fromString(model.getManager_id());

        try {
            restaurantInfoRepo.insertNewRestaurant(name, address, open, closing, imageURL, type, priceLevel, manager_id);
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
