drop table if exists customer_transactions;

CREATE TABLE customer_transactions (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(200) NOT NULL,
    transaction_amount INTEGER NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);