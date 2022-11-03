package com.company.crps.businessobjects;

public class MonthWiseTransactionAmount {

	private String month;
	private int totalAmount;

	public MonthWiseTransactionAmount(String month, int totalAmount) {
		super();
		this.month = month;
		this.totalAmount = totalAmount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
