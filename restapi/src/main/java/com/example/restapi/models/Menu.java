package com.example.restapi.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

@Entity
@Table(name = "restaurantmenu")
public class Menu{
    @Id
    @Column(name = "menu_uuid")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Menu_Id;

    @Column(name = "restaurant_uuid")
    private String Restaurant_Id;

    @OneToOne(mappedBy = "menu")
    Category category;
    
  

       public Menu() {


        }


    public Menu(String Menu_Id, String Restaurant_Id, Category category) {
        this.Menu_Id = Menu_Id;
        this.Restaurant_Id = Restaurant_Id;
       // this.category = category;
    }

    public String getMenu_Id() {
        return this.Menu_Id;
    }

    public void setMenu_Id(String Menu_Id) {
        this.Menu_Id = Menu_Id;
    }

    public String getRestaurant_Id() {
        return this.Restaurant_Id;
    }

    public void setRestaurant_Id(String Restaurant_Id) {
        this.Restaurant_Id = Restaurant_Id;
    }

  //  public Category getCategory() {
  //      return this.category;
  //  }

   // public void setCategory(Category category) {
   //     this.category = category;
    //}

   
   
}