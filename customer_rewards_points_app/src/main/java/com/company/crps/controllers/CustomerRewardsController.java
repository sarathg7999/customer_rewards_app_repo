package com.company.crps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.crps.businessobjects.CustomerRewardPoints;
import com.company.crps.businessobjects.CustomerTransaction;
import com.company.crps.service.CustomerRewardsService;

@RestController
public class CustomerRewardsController {

	@Autowired
	private CustomerRewardsService rewardsService;

	@GetMapping("/")
	public String index() {
		return "Welcome to CRPS(Customer Reward Points Application) -By Sarath";
	}

	@GetMapping("/getRewardPoints")
	@ResponseBody
	public CustomerRewardPoints getCustomerRewardPoints(
			final @RequestParam("customerName") String customerName,
			final @RequestParam("pastMonths") int pastMonths) {
		return rewardsService.getCustomerRewardPoints(customerName, pastMonths);
	}

	@GetMapping("/getAllTransactions")
	@ResponseBody
	public CustomerTransaction[] getTransactions() {
		return rewardsService.getAllCustomerTransactions().toArray(new CustomerTransaction[0]);
	}

}
