package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;
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

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "creation_ts")
    private Date creationTimeStamp;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "completion_ts")
    private Date completionTimeStamp;

    @Column(name = "delivery_location")
    private String delivery_location;

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

    public Orders (UUID order_id, String totalprice, Integer orderstatus, Date creationTimeStamp,
                   Date completionTimeStamp, String delivery_location) {
       this.order_id = order_id;
       this.totalprice = totalprice;
       this.orderstatus = orderstatus;
       this.creationTimeStamp = creationTimeStamp;
       this.completionTimeStamp = completionTimeStamp;
       this.delivery_location = delivery_location;
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
    public Date getCreationTimeStamp() { return creationTimeStamp; }

    @JsonView(View.Orders.class)
    public Date getCompletionTimeStamp() {
        return completionTimeStamp;
    }

    @JsonView(View.Orders.class)
    public String getDelivery_location() { return delivery_location; }

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
