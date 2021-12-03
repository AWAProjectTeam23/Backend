package com.example.restapi.models;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "restaurantmenu")

public class Menu {
    @Id
    @JsonIgnore
    @Column(name = "menu_uuid")
    private UUID Menu_Id;
  
    @Column(name = "restaurant_uuid")
    private UUID Restaurant_Id;

    @OneToMany(mappedBy = "menu")
    @JsonManagedReference
    public Set<Category> category;

    




    public UUID getMenu_Id() {
        return this.Menu_Id;
    }
/*
    public void setMenu_Id(UUID Menu_Id) {
        this.Menu_Id = Menu_Id;
    }
*/
    public UUID getRestaurant_Id() {
        return this.Restaurant_Id;
    }
/*
    public void setRestaurant_Id(UUID Restaurant_Id) {
        this.Restaurant_Id = Restaurant_Id;
    }
*/
    public Menu(UUID Menu_Id, UUID Restaurant_Id) {
        this.Menu_Id = Menu_Id;
        this.Restaurant_Id = Restaurant_Id;
    }

    public Menu() {
    }
    
}