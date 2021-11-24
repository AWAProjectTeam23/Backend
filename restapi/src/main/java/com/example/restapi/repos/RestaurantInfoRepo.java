package com.example.restapi.repos;

import com.example.restapi.models.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantInfoRepo extends JpaRepository<RestaurantInfo, String> {
}
