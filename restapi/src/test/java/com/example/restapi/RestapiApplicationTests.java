package com.example.restapi;

import com.example.restapi.services.RestaurantInfoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
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
