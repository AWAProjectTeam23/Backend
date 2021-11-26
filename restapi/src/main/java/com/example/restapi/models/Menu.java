package com.example.restapi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.ConstructorBinding;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "restaurantmenu")

public class Menu {
    @Id

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

    public void setMenu_Id(UUID Menu_Id) {
        this.Menu_Id = Menu_Id;
    }

    public UUID getRestaurant_Id() {
        return this.Restaurant_Id;
    }

    public void setRestaurant_Id(UUID Restaurant_Id) {
        this.Restaurant_Id = Restaurant_Id;
    }

    public Menu(UUID Menu_Id, UUID Restaurant_Id) {
        this.Menu_Id = Menu_Id;
        this.Restaurant_Id = Restaurant_Id;
    }

    public Menu() {
    }
    
}