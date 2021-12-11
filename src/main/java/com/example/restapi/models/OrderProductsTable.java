package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orderproducts")
public class OrderProductsTable {

    @Id
    @JsonIgnore
    @Column(name = "orderitem_uuid")
    private UUID orderItem_id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "product_uuid")
    private ProductTable productTable;

    @Column(name = "quantity")
    private Integer productQuantity;

    @ManyToOne
    @JsonBackReference
    @JsonView(View.Orders.class)
    @JoinColumn(name = "order_uuid")
    public Orders orders;

    public OrderProductsTable() {}

    public OrderProductsTable(UUID orderItem_id, Integer productQuantity, ProductTable productTable, Orders orders) {
        this.orderItem_id = orderItem_id;
        this.productQuantity = productQuantity;
    }

    @JsonView(View.Orders.class)
    public UUID getOrderItem_id() {
        return orderItem_id;
    }

    @JsonView(View.Orders.class)
    public Integer getProductQuantity() {
        return productQuantity;
    }

    @JsonView(View.Orders.class)
    public UUID getProduct_id() { return productTable.getItem_id(); }
}
