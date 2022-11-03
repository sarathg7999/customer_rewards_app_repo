package com.company.crps.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.company.crps.businessobjects.CustomerRewardPoints;
import com.company.crps.businessobjects.CustomerTransaction;

/**
 * Test cases to test the customer rewards end points.
 * 
 * NOTE : This case uses test data in src/main/resources/data.sql using
 * in-memory data base.
 * 
 * @author sarath
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRewardsControllerTest {

	@Autowired
	private TestRestTemplate template;

	@Test
	void testHomePage() throws Exception {
		ResponseEntity<String> response = template.getForEntity("/", String.class);
		assertEquals("Welcome to CRPS(Customer Reward Points Application) -By Sarath", response.getBody());
	}

	/**
	 * Test case to test reward points using in-memory H2 database when
	 * customerName=test1 and pastMonths=3.
	 * 
	 * NOTE : This case uses test data in src/main/resources/data.sql.
	 */
	@Test
	void testRewardPoints_success_scenario1() throws Exception {
		String monthsUrls = "/getRewardPoints?customerName=test1&pastMonths=3"; // testing with 3 months
		CustomerRewardPoints response = template.getForObject(monthsUrls, CustomerRewardPoints.class);
		assertNotNull(response);
		assertEquals("test1", response.getCustomerName());
		assertEquals(140, response.getTotalRewardPoints());
		Map<String, Integer> map = response.getMonthWiseRewardPoints();
		assertEquals(3, map.size());
		assertEquals(90, map.get("November-2022"));
		assertEquals(50, map.get("October-2022"));
		assertEquals(0, map.get("September-2022"));
	}

	/**
	 * Test case to test reward points using in-memory H2 database when
	 * customerName=test2 and pastMonths=2.
	 * 
	 * NOTE : This case uses test data in src/main/resources/data.sql.
	 */
	@Test
	void testRewardPoints_success_scenario2() throws Exception {
		String monthsUrls = "/getRewardPoints?customerName=test2&pastMonths=2"; // testing with 2 months
		CustomerRewardPoints response = template.getForObject(monthsUrls, CustomerRewardPoints.class);
		assertNotNull(response);
		assertEquals("test2", response.getCustomerName());
		assertEquals(190, response.getTotalRewardPoints());
		Map<String, Integer> map = response.getMonthWiseRewardPoints();
		assertEquals(2, map.size());
		assertEquals(150, map.get("November-2022"));
		assertEquals(40, map.get("October-2022"));
	}

	/**
	 * Test case to test all customer transactions.
	 * 
	 * NOTE : This case uses test data in src/main/resources/data.sql.
	 */
	@Test
	void testGetAllTransactions() {
		ResponseEntity<CustomerTransaction[]> response = template.getForEntity("/getAllTransactions",
				CustomerTransaction[].class);
		assertEquals(6, response.getBody().length);
	}

}
