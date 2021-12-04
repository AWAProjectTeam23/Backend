package com.example.restapi.repos;

import com.example.restapi.models.Orders;
import com.example.restapi.models.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, String> {

    @Query(value = "SELECT * FROM orders WHERE orders.restaurant_uuid = :id", nativeQuery = true)
    List<Orders> findManagerOrders(@Param("id") UUID restaurantID);

    @Query(value = "SELECT * FROM orders WHERE orders.customer_uuid = :id", nativeQuery = true)
    List<Orders> findCustomerOrders(@Param("id") UUID customerID);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO orders ( " +
                                        "order_uuid" +
                                        "customer_uuid, " +
                                        "restaurant_uuid, " +
                                        "totalprice, " +
                                        "orderstatus ) " +
                    "OUTPUT order_uuid " +
                    "VALUES ( " +
                                        "uuid_generate_v4(), " +
                                        ":customer_id, " +
                                        ":restaurant_id, " +
                                        ":totalprice, " +
                                        "1 )", nativeQuery = true)
    UUID insertOrder(@Param("customer_id") UUID customer_id,
                     @Param("restaurant_id") UUID restaurant_id,
                     @Param("totalprice") String totalPrice);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO orderproducts ( " +
            "orderitem_uuid, " +
            "order_uuid, " +
            "product_uuid, " +
            "quantity ) " +
            "VALUES (" +
            "uuid_generate_v4(), " +
            ":order_id, " +
            ":product_id, " +
            ":quantity )", nativeQuery = true)
    void insertOrderProducts(@Param("order_id") UUID order_id,
                             @Param("product_id") UUID product_id,
                             @Param("quantity") Integer quantity);


    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET orderstatus = :statusCode WHERE order_uuid = :order_id", nativeQuery = true)
    void updateOrderStatus(@Param("statusCode") Integer statusCode, @Param("order_id") UUID order_id);

}
