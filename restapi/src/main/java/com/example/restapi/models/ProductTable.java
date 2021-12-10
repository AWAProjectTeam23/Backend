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

    @Column(name = "categoryname")
    private String categoryName;

    @OneToMany(mappedBy = "productTable")
    @JsonBackReference
    public Set<OrderProductsTable> orderProducts;
  
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_uuid")
    public Category category;
  


    public ProductTable() {}

    public ProductTable(UUID item_id, String categoryName, String productName, String pricePer, String image, String productDescription) {
        this.item_id = item_id;
        this.productName = productName;
        this.pricePer = pricePer;
        this.image = image;
        this.productDescription = productDescription;
        this.categoryName = categoryName;
    
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


    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getImage() {
        return image;
    }
   
    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}