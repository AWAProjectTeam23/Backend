package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantinfo")
public class RestaurantInfo {

    @Id
    @Column(name = "restaurant_uuid")
    private UUID restaurantId;

    @Column(name = "restaurantmanager_uuid")
    private UUID restaurantManagerUserId;

    @Column(name = "restaurantname")
    private String restaurantName;

    @Column(name = "address")
    private String address;

    @Column(name = "operating_hours")
    private String operating_hours;

    @Column(name = "imageurl")
    private String imageURL;

    @Column(name = "restauranttype")
    private String restaurantStyle;

    @Column(name = "pricelevel")
    private String priceLevel;

    @OneToMany(mappedBy = "restaurantinfo")
    @JsonBackReference
    public Set<Orders> Orders;

    @OneToMany(mappedBy = "restaurantinfo")
    @JsonManagedReference
    public Set<Category> category;

    public RestaurantInfo() {
    }

    public RestaurantInfo(UUID restaurantId, UUID restaurantManagerUserId, String restaurantName, String address,
                          String operating_hours, String imageURL, String restaurantStyle, String priceLevel) {
        this.restaurantId = restaurantId;
        this.restaurantManagerUserId = restaurantManagerUserId;
        this.restaurantName = restaurantName;
        this.operating_hours = operating_hours;
        this.address = address;
        this.imageURL = imageURL;
        this.restaurantStyle = restaurantStyle;
        this.priceLevel = priceLevel;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public UUID getRestaurantManagerUserId() {
        return restaurantManagerUserId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public String getOperatingHour() {
        return operating_hours;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getRestaurantStyle() {
        return restaurantStyle;
    }

    public String getPriceLevel() {
        return priceLevel;
    }
}