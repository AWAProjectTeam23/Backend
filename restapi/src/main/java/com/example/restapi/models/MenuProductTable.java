package com.example.restapi.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "producttable")

  
public class MenuProductTable {
    @Id
    @Column(name = "item_uuid")
    private UUID Item_Id;

    @Column(name = "productname")
    private String ProductName;

    @Column(name = "price") 
    private String PricePer;

    @Column(name = "imageurl")
    private String ImageURL;

    @Column(name = "product_description")
    private String productDescription;


    
   @ManyToOne
   @JsonBackReference 
   @JoinColumn(name = "category_uuid")
   public Category category;
  
   /* FOR FUTURE
  @OneToMany(mappedBy =  "producttable")
  @JsonManagedReference
  public Set<OrderProducts> OrderProducts;
  */
  
    public MenuProductTable() {
    }

    public MenuProductTable(UUID Item_Id, String productDescription, String ProductName, String PricePer, String ImageURL) {
        this.Item_Id = Item_Id;
        this.ProductName = ProductName;
        this.PricePer = PricePer;
        this.ImageURL = ImageURL;
        this.productDescription = productDescription;
        
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public UUID getItem_Id() {
        return this.Item_Id;
    }

    public void setItem_Id(UUID Item_Id) {
        this.Item_Id = Item_Id;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getPricePer() {
        return this.PricePer;
    }

    public void setPricePer(String PricePer) {
        this.PricePer = PricePer;
    }

    public String getImageURL() {
        return this.ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }
     

}