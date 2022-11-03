package com.company.crps.businessobjects;

import java.time.LocalDateTime;

public class CustomerTransaction {

	private String customerName;
	private int transactionAmount;
	private LocalDateTime transactionDateAndTime;

	public CustomerTransaction(String customerName, int transactionAmount, LocalDateTime transactionDateAndTime) {
		super();
		this.customerName = customerName;
		this.transactionAmount = transactionAmount;
		this.transactionDateAndTime = transactionDateAndTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDateAndTime() {
		return transactionDateAndTime;
	}

	public void setTransactionDateAndTime(LocalDateTime transactionDateAndTime) {
		this.transactionDateAndTime = transactionDateAndTime;
	}

}
