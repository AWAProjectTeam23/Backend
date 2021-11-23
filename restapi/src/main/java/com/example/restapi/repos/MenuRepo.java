package com.example.restapi.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepo extends JpaRepository<Menu, String> {
    











    final String query1 = "SELECT * FROM restaurantmenu";
    @Query(value = query1, nativeQuery = true)
    List<Menu> getMenuInfo();
    //@Query(value = "SELECT * FROM RestaurantMenu", nativeQuery = true)
    //List<Menu> getMenuInfo();

    final String query2 = "SELECT * FROM category";
    @Query(value = query2, nativeQuery = true)
    List<Category> getCategoryInfo();
   
    //ypedQuery<Menu> query 
    //= EntityManager.createQuery()
   
    //SELECT restaurantmenu.menu_uuid, category.menu_uuid FROM restaurantmenu INNER JOIN category ON restaurantmenu.menu_uuid = category.menu_uuid


}
