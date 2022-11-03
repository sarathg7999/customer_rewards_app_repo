INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test1',120,CURRENT_TIMESTAMP()); --November
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test1',100,CURRENT_TIMESTAMP()-30); --October
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test1',50,CURRENT_TIMESTAMP()-60); --September

INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test2',150,CURRENT_TIMESTAMP()); --November
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test2',90,CURRENT_TIMESTAMP()-30);--October
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) 
VALUES ('test2',40,CURRENT_TIMESTAMP()-60); --September

