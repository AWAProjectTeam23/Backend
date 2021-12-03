package com.example.restapi.models;

import java.util.UUID;

public class OrderProducts {
    private UUID order_uuid;
    private String product_uuid;
    private Integer productQuantity;

    public OrderProducts(UUID order_uuid, String product_uuid, Integer productQuantity) {
        this.order_uuid = order_uuid;
        this.product_uuid = product_uuid;
        this.productQuantity = productQuantity;
    }
    public UUID getOrder_uuid() { return order_uuid; }

    public String getProduct_uuid() {
        return product_uuid;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }
}
