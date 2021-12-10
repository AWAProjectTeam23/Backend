package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "producttable")
public class ProductTable {

    @Id
    @Column(name = "item_uuid")
    private UUID item_id;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "productname")
    private String productName;
    
    @Column(name = "price")
    private String pricePer;

    @Column(name = "imageurl")
    private String image;


    @OneToMany(mappedBy = "productTable")
    @JsonBackReference
    public Set<OrderProductsTable> orderProducts;
  
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_uuid")
    public Category category;
  


    public ProductTable() {}

    public ProductTable(UUID item_id, String productName, String pricePer, String image, String productDescription) {
        this.item_id = item_id;
        this.productName = productName;
        this.pricePer = pricePer;
        this.image = image;
        this.productDescription = productDescription;
    
    
    }

    @JsonView(View.prodWithExtra.class)
    public UUID getItem_id() {
        return item_id;
    }
    @JsonView(View.prodWithExtra.class)
    public String getName() {
        return productName;
    }
    @JsonView(View.prodWithExtra.class)
    public String getPricePer() {
        return pricePer;
    }

    @JsonView(View.prodWithExtra.class)
    public String getImage() {
        return image;
    }
    @JsonView(View.prodWithExtra.class)
    public String getProductDescription() {
        return this.productDescription;
    }
    @JsonView(View.prodWithExtra.class)
    public String getCategoryName() {
        return category.getCategoryName();
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    
}