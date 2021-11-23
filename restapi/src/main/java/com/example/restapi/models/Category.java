package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @Column(name = "category_uuid")
    private String Category_Id;

    @Column(name = "categoryname")
    private String CategoryName;



    @ManyToOne
    @JoinColumn(name = "menu_uuid")
    private Menu menu;


    @OneToMany(mappedBy = "menuitems")
    private List<MenuItems> menuItemsList;



    public Category() {
    }


    


    public String getCategory_Id() {
        return this.Category_Id;
    }

    public void setCategory_Id(String Category_Id) {
        this.Category_Id = Category_Id;
    }

    public String getCategoryName() {
        return this.CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
/*
    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuItems> getMenuItemsList() {
        return this.menuItemsList;
    }

    public void setMenuItemsList(List<MenuItems> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }
*/
    public Category(String Category_Id, String CategoryName, Menu menu, List<MenuItems> menuItemsList) {
        this.Category_Id = Category_Id;
        this.CategoryName = CategoryName;
        //this.menu = menu;
       // this.menuItemsList = menuItemsList;
    }
    
}
