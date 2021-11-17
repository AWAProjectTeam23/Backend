package com.example.restapi.services;

import com.example.restapi.models.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface RestaurantInfoRepo extends JpaRepository<RestaurantInfo, String> {

    @Query(value = "SELECT * FROM restaurantinfo", nativeQuery = true)
    List<RestaurantInfo> getRestaurantInfo();
}
