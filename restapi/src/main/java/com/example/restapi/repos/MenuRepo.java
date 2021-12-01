package com.example.restapi.repos;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.restapi.DTO.DtoMenu;
import com.example.restapi.models.Category;
import com.example.restapi.models.Menu;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepo  extends JpaRepository<Menu, String> {
    
// WHERE restaurantmenu.restaurant_uuid = 'd84985f7-7a8b-4499-a49c-14acd3707c3a'

    final String query1 = "SELECT * FROM restaurantmenu";
    
    @Query(value = query1, nativeQuery = true)
    List<Menu> getMenuInfo();

    final String query2 = "SELECT * FROM restaurantmenu WHERE restaurantmenu.restaurant_uuid = :id";
   
    @Query(value = query2, nativeQuery = true)
    List<Menu> getMenuById(@Param("id") UUID id);

    //nem menu
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO restaurantmenu "+
            " ( "+
            "menu_uuid, "+
            "menuname, "+
            "restaurant_uuid "+
            " ) "+
                "VALUES "+
                " ( "+
                "uuid_generate_v4(), "+
                ":menuName, "+
                ":restaurant_id "+
                ")"      
                , nativeQuery = true)
    
    void addMenuToRestaurant(@Param("menuName") String menuName,
                            @Param("restaurant_id") UUID restaurant_id);

    
    
}