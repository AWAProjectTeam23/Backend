package com.example.restapi.repos;

import com.example.restapi.models.OrderProducts;
import com.example.restapi.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, String> {

    @Query(value = "SELECT * FROM orders WHERE orders.order_uuid = '17649dbd-10a7-4ab3-9819-be54173f409c'", nativeQuery = true)
    List<Orders> findByOrderNcustomerId();
}
