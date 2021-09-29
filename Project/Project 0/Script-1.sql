###########################################################
################## CREATE FRESH DATABASE ##################
###########################################################
DROP DATABASE IF EXISTS Banking_DB;
CREATE DATABASE Banking_DB;

USE Banking_DB;


DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS emails;
DROP TABLE IF EXISTS accounts_customers;
DROP TABLE IF EXISTS passwords;


CREATE TABLE accounts_customers 
(
	junction_id INT AUTO_INCREMENT,
	account_id 	INT NOT NULL ,
	customer_id INT NOT NULL,
	INDEX (account_id),
	INDEX (customer_id),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (junction_id)
);

CREATE TABLE emails
(
	junction_id INT AUTO_INCREMENT,
	customer_id INT NOT NULL,
	emails VARCHAR NOT NULL,
	INDEX (customers_id),
	INDEX (emails),
	CONSTRAINT emails_customers_fk PRIMARY KEY (junction_id)
);


CREATE TABLE customers 
(
	junction_id INT AUTO_INCREMENT,
	customer_id INT NOT NULL,
	name VARCHAR NOT NULL,
	INDEX (customer_id),
	INDEX (customer name),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (junction_id)
);

CREATE TABLE accounts
(
    account_id INT NOT NULL,
    balance DECIMAL (10, 2),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id), 
    CONSTRAINT accounts_accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);