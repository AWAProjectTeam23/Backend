package com.example.restapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;
import javax.print.DocFlavor.SERVICE_FORMATTED;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.web.servlet.FlashMapManager;

@Entity
@Table(name = "menuitems")
public class MenuItems {

    @Id
    @Column(name = "menuitemlist_uuid")
    private UUID MenuItemsList_Id;

    @Column(name = "item_uuid")
    private UUID Item_Id;
 
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_uuid")
    public Category category;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    public Set<MenuItems> menuItems;

   @OneToOne
   @JsonManagedReference
   @JoinColumn(name = "item_uuid", insertable = false, updatable = false)
   public ProductTable productTable;



    public UUID getMenuItemsList_Id() {
        return this.MenuItemsList_Id;
    }

    public void setMenuItemsList_Id(UUID MenuItemsList_Id) {
        this.MenuItemsList_Id = MenuItemsList_Id;
    }
    
    public UUID getItem_Id() {
        return this.Item_Id;
    }

    public void setItem_Id(UUID Item_Id) {
        this.Item_Id = Item_Id;
    }

    public MenuItems(UUID MenuItemsList_Id, UUID Item_Id, UUID Category_Id) {
        this.MenuItemsList_Id = MenuItemsList_Id;
        this.Item_Id = Item_Id;
        
    }

    public MenuItems() {
    }

}
