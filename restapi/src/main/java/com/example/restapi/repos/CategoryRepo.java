package com.example.restapi.repos;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import com.example.restapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepo extends JpaRepository<Category, String> {
    //Just for testing
    @Query (value = "SELECT * FROM category", nativeQuery = true)
    List<Category> getAllFromCat();

    //Adds new category
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO category "+
            "( "+
            "category_uuid, "+        
            "categoryname, "+
            "restaurant_uuid "+
            ") "+
                "VALUES "+
                     "( "+
                     "uuid_generate_v4(), "+
                     ":categoryName, "+
                     ":restaurantId "+
                     ") "
                     
                      , nativeQuery = true)
                     void addNewCategory(@Param("categoryName")String categoryName,
                                        @Param("restaurantId") UUID restaurantId);

}
