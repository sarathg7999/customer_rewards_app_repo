package com.company.crps.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.company.crps.businessobjects.CustomerRewardPoints;
import com.company.crps.businessobjects.CustomerTransaction;
import com.company.crps.businessobjects.MonthWiseTransactionAmount;
import com.company.crps.dao.CustomerRewardPointsDao;

@Component
public class CustomerRewardsServiceImpl implements CustomerRewardsService {

	@Value("${oneRewardPointsMaxAmount:50}")
	private int oneRewardPointsMaxAmount;

	@Value("${twoRewardPointsMaxAmount:100}")
	private int twoRewardPointsMaxAmount;

	@Autowired
	private CustomerRewardPointsDao dao;

	@Override
	public CustomerRewardPoints getCustomerRewardPoints(final String customerName, final int pastMonths) {
		List<MonthWiseTransactionAmount> monthAmountList = dao.getMonthWiseTransactionAmounts(customerName,
				pastMonths);
		Map<String, Integer> monthWiseRewardsMap = new LinkedHashMap<>();
		int totalRewardPoints = 0;
		for (MonthWiseTransactionAmount mAmount : monthAmountList) {
			int monthWiseRewardPoints = getRewardsPointsForAmount(mAmount.getTotalAmount());
			monthWiseRewardsMap.put(mAmount.getMonth(), monthWiseRewardPoints);
			totalRewardPoints = totalRewardPoints + monthWiseRewardPoints;
		}
		return new CustomerRewardPoints(customerName, monthWiseRewardsMap, totalRewardPoints);
	}

	@Override
	public List<CustomerTransaction> getAllCustomerTransactions() {
		return dao.getAllCustomerTransactions();
	}

	private int getRewardsPointsForAmount(final int amount) {
		int points = 0;
		if (amount >= twoRewardPointsMaxAmount) {
			int twoPointsAmount = amount - twoRewardPointsMaxAmount;
			points = (oneRewardPointsMaxAmount * 1) + (twoPointsAmount * 2);
		} else {
			if (amount <= oneRewardPointsMaxAmount) {
				points = 0;
			} else {
				points = amount - oneRewardPointsMaxAmount;
			}
		}
		return points;
	}

}
