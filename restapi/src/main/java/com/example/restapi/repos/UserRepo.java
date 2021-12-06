package com.example.restapi.repos;

import com.example.restapi.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, String> {
    public UserInfo findByUsername(String username);

    @Query(value = "SELECT user_uuid FROM userinfo WHERE username = :username", nativeQuery = true)
    String getUserID(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO userinfo (user_uuid, username, password, role) " +
            "VALUES (uuid_generate_v4(), :username, :password, :role)", nativeQuery = true)
    void insertNewAccount(@Param("username") String username,
                          @Param("password") String password,
                          @Param("role") String role);
}
