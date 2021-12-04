package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "producttable")
public class ProductTable {

    @Id
    @JsonIgnore
    @Column(name = "item_uuid")
    private UUID item_id;

    @Column(name = "productname")
    private String productName;

    @JsonIgnore
    @Column(name = "price")
    private String pricePer;

    @JsonIgnore     //REMOVE LATER
    @Column(name = "imageurl")
    private String image;

    @OneToMany(mappedBy = "productTable")
    @JsonBackReference
    public Set<OrderProductsTable> orderProducts;
  
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_uuid")
    public Category category;
  
    @Column(name = "product_description")
    private String productDescription;

    public ProductTable() {}

    public ProductTable(UUID item_id, String productName, String pricePer, String image) {
        this.item_id = item_id;
        this.productName = productName;
        this.pricePer = pricePer;
        this.image = image;
    }

    public UUID getItem_id() {
        return item_id;
    }

    public String getName() {
        return productName;
    }

    public String getPricePer() {
        return pricePer;
    }

    public String getImage() {
        return image;
    }
}