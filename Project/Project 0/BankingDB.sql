#Rashid's First Super Awesome SQL DataBase!


DROP DATABASE IF EXISTS Banking_DB; #Delete Old DB
CREATE DATABASE Banking_DB; #Start New DB
USE Banking_DB; #Default DB

#Remove any old data
DROP TABLE IF EXISTS balance;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS accounts_customers;
DROP TABLE IF EXISTS emails;
DROP TABLE IF EXISTS passwords;

#Begin creating tables for DB

CREATE TABLE accounts_customers 
(
	account_id 	INT NOT NULL,
	customer_id INT NOT NULL,
	INDEX (account_id),
	INDEX (customer_id),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (account_id)
);

CREATE TABLE balance
(
    account_id INT NOT NULL,
    balance DECIMAL (10, 2),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id), 
    CONSTRAINT accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);

CREATE TABLE customers 
(
	customer_id INT NOT NULL,
	name VARCHAR(200),
	INDEX (customer_id),
	INDEX (name),
	CONSTRAINT customers_pk PRIMARY KEY (customer_id), 
	CONSTRAINT customers_accounts_fk  FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id)
);

CREATE TABLE emails
(
	customer_id INT NOT NULL,
	emails VARCHAR(200),
	INDEX (customer_id),
	INDEX (emails),
	CONSTRAINT emails_pk PRIMARY KEY (customer_id), 
	CONSTRAINT emails_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id)
);

CREATE TABLE password
(
	customer_id INT NOT NULL,
	password VARCHAR(200),
	INDEX (customer_id),
	INDEX (password),
	CONSTRAINT password_pk PRIMARY KEY (customer_id), 
	CONSTRAINT password_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id)
);


###########################################################
################# POPULATE DATABASE #######################
###########################################################

