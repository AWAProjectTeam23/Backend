package com.example.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RestaurantMenu")
public class Menu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Menu_Id;

    @Column(name = "restaurant_Id")
    private Long Restaurant_Id;

    public Menu(Long Menu_Id, Long Restaurant_Id) {
        this.Menu_Id = Menu_Id;
        this.Restaurant_Id = Restaurant_Id;
    }

    public Long getMenu_Id() {
        return this.Menu_Id;
    }

    public void setMenu_Id(Long Menu_Id) {
        this.Menu_Id = Menu_Id;
    }

    public Long getRestaurant_Id() {
        return this.Restaurant_Id;
    }

    public void setRestaurant_Id(Long Restaurant_Id) {
        this.Restaurant_Id = Restaurant_Id;
    }

}
