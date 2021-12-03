package com.example.restapi.repos;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import com.example.restapi.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepo  extends JpaRepository<Menu, String> {
    
    //Just for testing
    final String query1 = "SELECT * FROM restaurantmenu";
    
    @Query(value = query1, nativeQuery = true)
    List<Menu> getMenuInfo();

    //Get information based on id
    final String query2 = "SELECT * FROM restaurantmenu WHERE restaurant_uuid = :id";
   
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