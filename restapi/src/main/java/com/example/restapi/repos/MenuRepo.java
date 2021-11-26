package com.example.restapi.repos;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepo  extends JpaRepository<Menu, String> {
    


    final String query1 = "SELECT * FROM restaurantmenu WHERE restaurantmenu.menu_uuid = '51421780-2e33-4c77-8942-2f9441d8c82e'";
    
    @Query(value = query1, nativeQuery = true)
    List<Menu> getMenuInfo();

    final String query2 = "SELECT * FROM restaurantmenu WHERE restaurantmenu.restaurant_uuid = ?1";
   
    @Query(value = query2, nativeQuery = true)
    List<Menu> getMenuById(UUID id);




}
