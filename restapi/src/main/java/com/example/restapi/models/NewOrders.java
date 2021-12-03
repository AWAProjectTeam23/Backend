package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;

public class NewOrders {
    private final String customer_uuid;
    private final String restaurant_uuid;
    private final String totalPrice;
    public List<OrderProducts> orderProducts;

    public NewOrders(String customer_uuid, String restaurant_uuid, String totalPrice, List<OrderProducts> orderProducts) {
        this.customer_uuid = customer_uuid;
        this.restaurant_uuid = restaurant_uuid;
        this.totalPrice = totalPrice;
        this.orderProducts = orderProducts;
    }

    public String getCustomer_uuid() {
        return customer_uuid;
    }

    public String getRestaurant_uuid() {
        return restaurant_uuid;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }
}
