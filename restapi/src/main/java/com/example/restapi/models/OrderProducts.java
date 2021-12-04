package com.example.restapi.models;

import java.util.UUID;

public class OrderProducts {
    private String product_uuid;
    private Integer productQuantity;

    public OrderProducts(String product_uuid, Integer productQuantity) {
        this.product_uuid = product_uuid;
        this.productQuantity = productQuantity;
    }

    public String getProduct_uuid() {
        return product_uuid;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }
}
