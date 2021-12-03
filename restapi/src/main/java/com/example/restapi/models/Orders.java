package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_uuid")
    private UUID order_id;

    @Column(name = "totalprice")
    private String totalprice;

    @Column(name = "orderstatus")
    private Integer orderstatus;

    @Column(name = "completion_ts")
    private String completionTimeStamp;

    @OneToMany(mappedBy = "orders")
    @JsonManagedReference
    @JsonView(View.Orders.class)
    public Set<OrderProductsTable> orderproducts;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "restaurant_uuid")
    public RestaurantInfo restaurantinfo;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "customer_uuid")
    public UserInfo userinfo;

    public Orders() {
    }

    public Orders (UUID order_id, String totalprice, Integer orderstatus, String completionTimeStamp) {
       this.order_id = order_id;
       this.totalprice = totalprice;
       this.orderstatus = orderstatus;
       this.completionTimeStamp = completionTimeStamp;
    }

    @JsonView(View.Orders.class)
    public UUID getOrder_id() {
        return order_id;
    }

    @JsonView(View.Orders.class)
    public String getTotal_price() {
        return totalprice;
    }

    @JsonView(View.Orders.class)
    public Integer getOrder_status() {
        return orderstatus;
    }

    @JsonView(View.Orders.class)
    public String getCompletionTime() {
        return completionTimeStamp;
    }

    @JsonView(View.OrdersWithRestaurantName.class)
    public String getRestaurantName() {
        return restaurantinfo.getRestaurantName();
    }

    @JsonView(View.Orders.class)
    public UUID getRestaurantID() {
        return restaurantinfo.getRestaurantId();
    }

    @JsonView(View.OrdersWithCustomerName.class)
    public String getCustomerName() { return userinfo.getUsername(); }

    @JsonView(View.Orders.class)
    public UUID getCustomerID() { return userinfo.getUser_id(); }
}
