package com.example.restapi.models;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantModel {
    private MultipartFile image;
    private String restaurantName;
    private String address;
    private String open_hour;
    private String closing_hour;
    private String style;
    private String priceLevel;
    private String manager_id;

    public RestaurantModel(MultipartFile image, String manager_id, String restaurantName,
                           String address, String open_hour, String closing_hour, String style, String priceLevel) {
        this.image = image;
        this.restaurantName = restaurantName;
        this.address = address;
        this.open_hour = open_hour;
        this.closing_hour = closing_hour;
        this.style = style;
        this.priceLevel = priceLevel;
        this.manager_id = manager_id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public String getManager_id() {
        return manager_id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public String getOpen_hour() {
        return open_hour;
    }

    public String getClosing_hour() {
        return closing_hour;
    }

    public String getStyle() {
        return style;
    }

    public String getPriceLevel() {
        return priceLevel;
    }
}
