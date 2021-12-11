package com.example.restapi.models;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantModel {
    private MultipartFile image;
    private String restaurantName;
    private String address;
    private String operating_hours;
    private String style;
    private String priceLevel;

    public RestaurantModel(MultipartFile image, String restaurantName,
                           String address, String operating_hours, String style, String priceLevel) {
        this.image = image;
        this.restaurantName = restaurantName;
        this.address = address;
        this.operating_hours = operating_hours;
        this.style = style;
        this.priceLevel = priceLevel;
    }

    public MultipartFile getImage() {
        return image;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public String getOperating_hours() {
        return operating_hours;
    }

    public String getStyle() {
        return style;
    }

    public String getPriceLevel() {
        return priceLevel;
    }
}
