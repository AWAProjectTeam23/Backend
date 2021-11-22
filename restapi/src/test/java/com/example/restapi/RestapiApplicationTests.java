package com.example.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import com.example.restapi.repos.RestaurantInfoRepo;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class RestapiApplicationTests {


	@Autowired
	DataSource dataSource;

	@Test
	void connectionTester() throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
			var info = connection.getCatalog();
		}


	}

}
