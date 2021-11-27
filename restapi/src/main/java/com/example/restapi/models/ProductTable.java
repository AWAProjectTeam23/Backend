package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producttable")
public class ProductTable {

    @Id
    @JsonIgnore
    @Column(name = "item_uuid")
    private String item_id;

    @Column(name = "productname")
    private String productName;

    @JsonIgnore
    @Column(name = "price")
    private String priceper;

    @JsonIgnore     //REMOVE LATER
    @Column(name = "imageurl")
    private String image;

    @OneToMany(mappedBy = "productTable")
    @JsonBackReference
    public Set<OrderProducts> orderProducts;

    public ProductTable() {}

    public ProductTable(String item_id, String productName, String priceper, String image) {
        this.item_id = item_id;
        this.productName = productName;
        this.priceper = priceper;
        this.image = image;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getName() {
        return productName;
    }

    public String getPriceper() {
        return priceper;
    }

    public String getImage() {
        return image;
    }

    //public Set<OrderProducts> getOrderProducts() {
     //   return orderProducts;
    //}
}
