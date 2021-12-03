package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

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

    @Column(name = "open_hour")
    private String open_hour;

    @Column(name = "closing_hour")
    private String closing_hour;

    @Column(name = "imageurl")
    private String imageURL;

    @Column(name = "restauranttype")
    private String restaurantStyle;

    @Column(name = "pricelevel")
    private String priceLevel;

    @OneToMany(mappedBy = "restaurantinfo")
    @JsonBackReference
    public Set<Orders> Orders;

    public RestaurantInfo() {}

    public RestaurantInfo(UUID restaurantId, UUID restaurantManagerUserId, String restaurantName, String address,
                          String open_hour, String closing_hour, String imageURL, String restaurantStyle, String priceLevel)
    {
        this.restaurantId = restaurantId;
        this.restaurantManagerUserId = restaurantManagerUserId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.open_hour = open_hour;
        this.closing_hour = closing_hour;
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
        return open_hour + " " + closing_hour;
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
