package com.example.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "restaurantinfo")
public class RestaurantInfo {
    @Id
    @Column(name = "restaurant_uuid")
    private String restaurantId;
    //private String restaurantManagerUserId;

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



    public String getInfo() {
        return restaurantId + " " +
                restaurantName + " " +
                address + " " +
                open_hour + " - " +
                closing_hour + " " +
                imageURL + " " +
                restaurantStyle + " " +
                priceLevel;
    }


    public void setId(String  restaurantId) {
        this.restaurantId = restaurantId;
    }

    public RestaurantInfo() {

    }

    public RestaurantInfo(String restaurantName){
        this.restaurantName = restaurantName;

    }

    public RestaurantInfo(String restaurantId, String restaurantName, String address,
                          String open_hour, String closing_hour, String imageURL, String restaurantStyle, String priceLevel)
    {
        this.restaurantId = restaurantId;
        //this.restaurantManagerUserId = restaurantManagerUserId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.open_hour = open_hour;
        this.closing_hour = closing_hour;
        this.imageURL = imageURL;
        this.restaurantStyle = restaurantStyle;
        this.priceLevel = priceLevel;
    }
}
