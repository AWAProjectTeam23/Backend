package com.example.restapi.repos;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import com.example.restapi.models.ProductTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  ProductTableRepo extends JpaRepository<ProductTable, String>{


    //new item
  /*  @Transactional
    @Modifying
    @Query(value = "INSERT INTO productable"+
                "( "+
                "item_id, "+
                "productname, "+
                 "price, "+
                 "imgurl, "+
                 "menuitems.menuitems_uuid, "+
                 "category.category_uuid "+
                    " ) " +

                        "FULL OUTER JOIN "+
                         "productable.item_uuid "+ 
                         "ON menuitems.item_uuid "+
                         "menuitems.category_uuid ON"+
                         "category.category_uuid"+
                         "VALUES "+ 

                      "( "+
                          "uuid_generate_v4(), "+
                          ":productName , "+ 
                          ":price, "+
                          ":imgURL, "+
                          ":restaurantName, "+
                          ":menuItemList_id, "+
                          ":caegory_id "+
                      " )" , nativeQuery = true)

                    void addProductsUsingCategory(@Param("productName") String productName,
                                                    @Param("price") String price,
                                                    @Param("imgURL") String imgURL, 
                                                    @Param("restaurantName") String restaurantName,
                                                    @Param("menuItemsList_id") UUID menuItemsList_id,
                                                    @Param("category_id") UUID category_id);
*/                                                   

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO producttable"+
    " ( "+
    "item_uuid, "+
    "productname, "+
    "price, "+
    "ImageURL "+
    " ) "+
        "VALUES "+
            " ( "+
            "uuid_generate_v4(), "+
            ":productname, "+
            ":price, "+
            ":imageURL "+
            ")" , nativeQuery = true)

            void insertToProductable(@Param("productname") String productName, 
                                     @Param("price") String price,
                                     @Param("imageURL") String imageURL);


    
    @Query(value = "SELECT item_uuid FROM producttable "+ 
                    "WHERE producttable.productname= :productName", nativeQuery = true )
                List<ProductTable> getIdBuffer(@Param("productName") String productName);

   }
