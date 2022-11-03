package com.company.crps.service;

import java.util.List;

import com.company.crps.businessobjects.CustomerRewardPoints;
import com.company.crps.businessobjects.CustomerTransaction;

public interface CustomerRewardsService {

	CustomerRewardPoints getCustomerRewardPoints(final String customerName, final int pastMonths);

	List<CustomerTransaction> getAllCustomerTransactions();
}
