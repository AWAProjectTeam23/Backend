package com.example.restapi.models;

import org.springframework.web.multipart.MultipartFile;

public class ProductModel {
    private MultipartFile image;
    private String productName;
    private String price;
    private String product_description;
    private String category_uuid;

    public ProductModel(MultipartFile image, String productName, String price, String product_description, String category_uuid) {
        this.image = image;
        this.productName = productName;
        this.price = price;
        this.product_description = product_description;
        this.category_uuid = category_uuid;
    }

    public MultipartFile getImage() {
        return image;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String  getCategory_uuid() {
        return category_uuid;
    }
}
