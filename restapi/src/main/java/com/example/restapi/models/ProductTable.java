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
    @Column(name = "item_uuid")
    private String item_id;

    @Column(name = "productname")
    private String name;

    @JsonIgnore
    @Column(name = "price")
    private String priceper;

    @JsonIgnore     //REMOVE LATER
    @Column(name = "imageurl")
    private String image;

    @OneToMany(mappedBy = "productTable")
    //@JsonIgnore
    @JsonBackReference
    public Set<OrderProducts> orderProducts;

    public ProductTable() {}

    public ProductTable(String item_id, String name, String priceper, String image) {
        this.item_id = item_id;
        this.name = name;
        this.priceper = priceper;
        this.image = image;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getName() {
        return name;
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
