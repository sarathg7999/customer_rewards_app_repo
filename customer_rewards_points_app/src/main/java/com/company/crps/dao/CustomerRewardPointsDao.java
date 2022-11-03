package com.company.crps.dao;

import java.util.List;

import com.company.crps.businessobjects.CustomerTransaction;
import com.company.crps.businessobjects.MonthWiseTransactionAmount;

public interface CustomerRewardPointsDao {

	List<CustomerTransaction> getAllCustomerTransactions();

	List<MonthWiseTransactionAmount> getMonthWiseTransactionAmounts(final String customerName,
			final int pastMonths);
}
