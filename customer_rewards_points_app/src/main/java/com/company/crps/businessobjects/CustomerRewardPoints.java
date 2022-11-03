package com.company.crps.businessobjects;

import java.util.Map;

public class CustomerRewardPoints {
	private String customerName;
	private Map<String, Integer> monthWiseRewardPoints;
	private int totalRewardPoints;
	
	public CustomerRewardPoints(String customerName, Map<String, Integer> monthWiseRewardPoints,
			int totalRewardPoints) {
		super();
		this.customerName = customerName;
		this.monthWiseRewardPoints = monthWiseRewardPoints;
		this.totalRewardPoints = totalRewardPoints;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<String, Integer> getMonthWiseRewardPoints() {
		return monthWiseRewardPoints;
	}

	public void setMonthWiseRewardPoints(Map<String, Integer> monthWiseRewardPoints) {
		this.monthWiseRewardPoints = monthWiseRewardPoints;
	}

	public int getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(int totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

}
