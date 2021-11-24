package com.example.restapi.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonIgnore
    @Column(name = "orderstatus")
    private Integer orderstatus;

    @Column(name = "completion_ts")
    private String completionTime;

    @OneToMany(mappedBy = "orders")
    @JsonManagedReference
    public Set<OrderProducts> orderproducts;



    public Orders () {}

    public Orders (UUID order_id, String totalprice, Integer orderstatus, String completionTime) {
       this.order_id = order_id;
       this.totalprice = totalprice;
       this.orderstatus = orderstatus;
       this.completionTime = completionTime;
    }

    public UUID getOrder_id() {
        return order_id;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    //public Set<OrderProducts> getOrderproducts() {
        //return orderproducts;
    //}
}
