package com.example.restapi.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import antlr.collections.List;

//owning side


@Entity
@Table(name = "producttable")

public class ProductTable {
    @Id
    @Column(name = "item_uuid")
    private UUID Item_Id;

    @Column(name = "productname")
    private String ProductName;

    @Column(name = "price") 
    private String PricePer;

    @Column(name = "imageurl")
    private String ImageURL;
    
    
   @OneToOne(mappedBy =  "productTable")
   @JsonBackReference
   public MenuItems menuItems; 
  
    public ProductTable() {
    }

    public ProductTable(UUID Item_Id, String ProductName, String PricePer, String ImageURL) {
        this.Item_Id = Item_Id;
        this.ProductName = ProductName;
        this.PricePer = PricePer;
        this.ImageURL = ImageURL;
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