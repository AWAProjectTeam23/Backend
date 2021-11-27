package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    public Set<OrderProducts> orderproducts;

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



    public Orders () {}

    public Orders (UUID order_id, String totalprice, Integer orderstatus, String completionTimeStamp) {
       this.order_id = order_id;
       this.totalprice = totalprice;
       this.orderstatus = orderstatus;
       this.completionTimeStamp = completionTimeStamp;
    }

    public UUID getOrder_id() {
        return order_id;
    }

    public String getTotal_price() {
        return totalprice;
    }

    public Integer getOrder_status() {
        return orderstatus;
    }

    public String getCompletionTime() {
        return completionTimeStamp;
    }

    public String getRestaurantName() {
        return restaurantinfo.getRestaurantName();
    }

    public String getCustomerName() { return userinfo.getUsername(); }
}
