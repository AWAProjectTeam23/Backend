package com.example.restapi.repos;

import com.example.restapi.models.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.Time;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantInfoRepo extends JpaRepository<RestaurantInfo, String> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO restaurantinfo " +
            "(" +
            "restaurant_uuid, " +
            "restaurantname, " +
            "address, " +
            "open_hour, " +
            "closing_hour, " +
            "imageurl, " +
            "restauranttype, " +
            "pricelevel, " +
            "restaurantmanager_uuid" +
            ")" +
            "VALUES" +
            "(" +
                    "uuid_generate_v4(), " +
                    ":restName, " +
                    ":address, " +
                    ":open, " +
                    ":closing, " +
                    ":image, " +
                    ":type, " +
                    ":priceLevel, " +
                    ":manager_uuid" +
                    ")"
            , nativeQuery = true)
    void insertNewRestaurant(@Param("restName") String restName,
                             @Param("address") String address,
                             @Param("open") Time open,
                             @Param("closing") Time closing,
                             @Param("image") String image,
                             @Param("type") String type,
                             @Param("priceLevel") Integer priceLevel,
                             @Param("manager_uuid") UUID manager_id);


final String query2 = "SELECT * FROM restaurantinfo WHERE restaurant_uuid = :id";
   
@Query(value = query2, nativeQuery = true)
List<RestaurantInfo> getMenuById(@Param("id") UUID id);

}
