package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @Column(name = "category_uuid", insertable = false, updatable =  false )
    private UUID Category_Id;

    @Column(name = "categoryname")
    private String CategoryName;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "menu_uuid")
    public Menu menu;


    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    public Set<ProductTable> productTable;

    public UUID getCategory_Id() {
        return this.Category_Id;
    }

    public void setCategory_Id(UUID Category_Id) {
        this.Category_Id = Category_Id;
    }

    public String getCategoryName() {
        return this.CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public Category(UUID Category_Id, String CategoryName) {
        this.Category_Id = Category_Id;
        this.CategoryName = CategoryName;
    }

    public Category() {
    }
    
}