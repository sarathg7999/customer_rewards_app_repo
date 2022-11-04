# customer_rewards_app_repo
Customer Reward Points Application Repository

Techologies used:

1. JDK 1.8 or later
2. Maven 3.2+
3. Spring Boot 2.7.5
4. In memory H2 DB 

NOTE  : This application use in memory H2 DB.  By default this inserts some customer 
transactions/purchases by taking data from src/main/resources/data.sql


How to run the application :

After doing maven clean and install 
1. Go to 'com.company.crps.Application.java' and run as 'java application'
2. Open http://localhost:8080/  ( You must see welcome message -'Welcome to CRPS(Customer Reward Points Application) -By Sarath' )
3. Open H2 Db : http://localhost:8080/h2-console
DB : jdbc:h2:mem:test
user : sa
Pwd : <no password>
( We can insert some more customer transactions from this h2_console DB as well. 
For sample insert statements check : src/main/resources/data.sql ) 
Example :

INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) VALUES ('test3',150,'2022-11-04 01:49:00.5'); 
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) VALUES ('test3',90,'2022-11-04 01:49:00.5');
INSERT INTO customer_transactions (customer_name, transaction_amount,transaction_date) VALUES ('test3',200,'2022-10-04 01:49:00.5'); 
commit;

How to use the application :

1. View Customer transactions : 

http://localhost:8080/getAllTransactions  

2. To calculate rewards take customer name from step 1 response and give past months as below ) 

Ex : http://localhost:8080/getRewardPoints?customerName=test1&pastMonths=3


JUnit Test cases :

1. com.company.crps.controllers.CustomerRewardsControllerTest.java

This give code coverage >85 %
