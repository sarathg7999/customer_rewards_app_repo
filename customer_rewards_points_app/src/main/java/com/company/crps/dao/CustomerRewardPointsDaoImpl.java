package com.company.crps.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.company.crps.businessobjects.CustomerTransaction;
import com.company.crps.businessobjects.MonthWiseTransactionAmount;

@Component
public class CustomerRewardPointsDaoImpl implements CustomerRewardPointsDao {
	private static final String ALL_TRANS_QUERY = "SELECT * FROM customer_transactions";

	private static final String GET_CUST_TRANS_QUERY = "select "
			+ " MONTHNAME(transaction_date) as month_name, YEAR(transaction_date) as year_value, "
			+ " sum(transaction_amount) as amount from customer_transactions "
			+ " where MONTH(transaction_date) > ? AND  customer_name = ? group by MONTHNAME(transaction_date) order by MONTH(transaction_date) asc";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerTransaction> getAllCustomerTransactions() {
		return jdbcTemplate.query(ALL_TRANS_QUERY,
				(rs, rowNum) -> new CustomerTransaction(rs.getString("customer_name"), rs.getInt("transaction_amount"),
						rs.getTimestamp("transaction_date").toLocalDateTime()));
	}

	@Override
	public List<MonthWiseTransactionAmount> getMonthWiseTransactionAmounts(final String customerName,
			final int pastMonths) {
		return jdbcTemplate.query(GET_CUST_TRANS_QUERY,
				(rs, rowNum) -> new MonthWiseTransactionAmount(
						rs.getString("month_name") + "-" + rs.getString("year_value"), rs.getInt("amount")),
				LocalDateTime.now().getMonthValue() - pastMonths, customerName);
	}

}
