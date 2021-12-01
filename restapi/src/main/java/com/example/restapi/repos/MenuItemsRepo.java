package com.example.restapi.repos;

import java.util.UUID;

import javax.swing.UIClientPropertyKey;
import javax.transaction.Transactional;

import com.example.restapi.models.MenuItems;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuItemsRepo extends JpaRepository<MenuItems, String> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO menuitems "+
                    "( "+
                    "menuitemlist_uuid, "+
                    "category_uuid, "+
                    "item_uuid"+
                    ") "+
                        "VALUES "+
                            "( "+
                            "uuid_generate_v4(), "+
                            ":category_id, "+
                            ":item_id"+
                            ")" 
                            
                        , nativeQuery = true)
                   void addNewMenuItemsList(@Param("category_id")UUID category_id,
                                            @Param("item_id")UUID item_id); 
    

   
                                            
}
