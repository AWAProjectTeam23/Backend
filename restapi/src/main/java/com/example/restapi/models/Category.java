package com.example.restapi.models;



import java.util.Set;
import java.util.UUID;

import javax.annotation.Priority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.security.core.authority.mapping.MappableAttributesRetriever;



@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @JsonIgnore
    @Column(name = "category_uuid", insertable = false, updatable =  false )
    private UUID Category_Id;
    @JsonIgnore
    @Column(name = "categoryname")
    private String CategoryName;
    

   
    
    @ManyToOne
    @JsonBackReference
    //@JsonIgnore
    @JoinColumn(name = "restaurant_uuid")
    public RestaurantInfo restaurantinfo;


    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    public Set<ProductTable> productTable;

    

    public UUID getCategory_Id() {
        return this.Category_Id;
    }
/*
    public void setCategory_Id(UUID Category_Id) {
        this.Category_Id = Category_Id;
    }
*/
    public String getCategoryName() {
        return this.CategoryName;
    }
/*
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
*/
    public Category(UUID Category_Id, String CategoryName) {
        this.Category_Id = Category_Id;
        this.CategoryName = CategoryName;
        
    }

    public Category() {
    }
    
}