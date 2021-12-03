package com.example.restapi.repos;


import java.util.UUID;
import javax.transaction.Transactional;
import com.example.restapi.models.ProductTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  ProductTableRepo extends JpaRepository<ProductTable, String>{

   

    //Adding new products to producttable
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO producttable"+
    " ( "+
    "item_uuid, "+
    "productname, "+
    "price, "+
    "imageurl, "+
    "product_description, "+
    "category_uuid "+
    " ) "+
        "VALUES "+
            " ( "+
            "uuid_generate_v4(), "+
            ":productName, "+
            ":price, "+
            ":imageurl, "+
            ":product_description, "+
            ":category_id "+
            ")" , nativeQuery = true)

            void insertNewProduct (@Param("productName") String productName, 
                                     @Param("price") String price,
                                     @Param("imageurl") String imageurl,
                                     @Param("product_description") String product_description,
                                     @Param("category_id") UUID category_id
                                     );




   }
 