package com.example.restapi.repos;

import com.example.restapi.models.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    
    //

}
