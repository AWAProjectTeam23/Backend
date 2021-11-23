package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menuitems")
public class MenuItems {
    @Id
    @Column(name = "menuitemslist_uuid")
    private String MenuItemsList_Id;

    @Column(name = "item_uuid")
    private String Item_Id;



    @ManyToOne
    @JoinColumn(name = "category_uuid")
    private Category category;


    public MenuItems() {
    }

    public String getMenuItemsList_Id() {
        return this.MenuItemsList_Id;
    }

    public void setMenuItemsList_Id(String MenuItemsList_Id) {
        this.MenuItemsList_Id = MenuItemsList_Id;
    }

    public String getItem_Id() {
        return this.Item_Id;
    }

    public void setItem_Id(String Item_Id) {
        this.Item_Id = Item_Id;
    }
/*
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
*/
    public MenuItems(String MenuItemsList_Id, String Item_Id, Category category) {
        this.MenuItemsList_Id = MenuItemsList_Id;
        this.Item_Id = Item_Id;
        //this.category = category;
    }

  

}
