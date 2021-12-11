package com.example.restapi.services;

import com.example.restapi.models.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IWebsiteService {
    List<?> getRestaurants();

    List<?> getRestaurantsOfManager(UUID id);

    List<?> allCustomerOrders(UUID id);

    List<?> allManagerOrders(UUID id);

    List<?> getMenuWithParm(UUID id);
    
    List<?> getStuffFromProd(UUID id);

    boolean storeOrderInfo(NewOrders body, UUID id);

    boolean updateOrderStatus(Map<String, String> body);

    boolean storeRestaurantInfo(RestaurantModel model, String imageURL, UUID manager_id);

    boolean storeAccountInfo(Map<String, String> body);

    boolean addNewCategory(Map<String, String> body);

    boolean addNewProduct(ProductModel body, String imageUrl);
}