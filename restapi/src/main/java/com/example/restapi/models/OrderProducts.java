package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orderproducts")
public class OrderProducts {

    @Id
    @Column(name = "orderitem_uuid")
    private UUID orderItem_id;

    @Column(name = "quantity")
    private Integer productQuantity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_uuid")
    public Orders orders;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "product_uuid")
    private ProductTable productTable;





    public OrderProducts() {}

    public OrderProducts(UUID orderItem_id, Integer productQuantity, ProductTable productTable, Orders orders) {
        this.orderItem_id = orderItem_id;
        this.productQuantity = productQuantity;
        //this.productTable = productTable;
        //this.orders = orders;
    }

    public UUID getOrderItem_id() {
        return orderItem_id;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }


}
