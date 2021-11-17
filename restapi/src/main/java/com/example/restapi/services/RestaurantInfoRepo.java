package com.example.restapi.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface WebsiteDatabaseService extends JpaRepository<> {

    //@Query("SELECT * FROM restaurantinfo;")
    //List<RestaurantInfo> getRestaurantsFromDB();
}
