package com.example.restapi.repos;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, String> {

    @Query(value = "SELECT * FROM orders WHERE orders.restaurant_uuid = :id", nativeQuery = true)
    List<Orders> findManagerOrders(@Param("id") UUID restaurantID);

    @Query(value = "SELECT * FROM orders WHERE orders.customer_uuid = :id", nativeQuery = true)
    List<Orders> findCustomerOrders(@Param("id") UUID customerID);

}
