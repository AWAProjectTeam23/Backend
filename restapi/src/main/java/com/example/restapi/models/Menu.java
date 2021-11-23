package com.example.restapi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.ConstructorBinding;

@Entity
@Table(name = "restaurantmenu")
public class Menu{
    @Id
    @Column(name = "menu_uuid")
    private String Menu_Id;
  
    @Column(name = "restaurant_uuid")
    private String Restaurant_Id;


    @OneToMany(mappedBy = "menu")
      private List<Category> categoryList;  
  

       public Menu() {


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

    /*public List<Category> getCategoryList() {
        return this.categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    */
    public Menu(String Menu_Id, String Restaurant_Id, List<Category> categoryList) {
        this.Menu_Id = Menu_Id;
        this.Restaurant_Id = Restaurant_Id;
        //this.categoryList = categoryList;
    }
   
   
   
}