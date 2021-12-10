package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;

public class NewOrders {
    private final String restaurant_uuid;
    private final String totalPrice;
    private final String delivery_location;
    public List<OrderProducts> orderProducts;

    public NewOrders(String restaurant_uuid, String totalPrice,
                     List<OrderProducts> orderProducts, String delivery_location) {
        this.restaurant_uuid = restaurant_uuid;
        this.totalPrice = totalPrice;
        this.orderProducts = orderProducts;
        this.delivery_location = delivery_location;
    }

    public String getRestaurant_uuid() {
        return restaurant_uuid;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getDelivery_location() { return delivery_location; }

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }
}
