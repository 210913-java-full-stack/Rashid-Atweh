#Rashid's First Super Awesome SQL DataBase!


DROP DATABASE IF EXISTS Banking_DB; #Delete Old DB
CREATE DATABASE Banking_DB; #Start New DB
USE Banking_DB; #Default DB

#Remove any old data
DROP TABLE IF EXISTS balances;
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

CREATE TABLE balances
(
    account_id INT NOT NULL,
    balance DECIMAL (10, 2),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id), 
    CONSTRAINT accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);

CREATE TABLE customers 
(
	customer_id INT AUTO_INCREMENT,
	#account_id INT NOT NULL,
	fname VARCHAR(200),
	lname VARCHAR(200),
	uname VARCHAR(200),
	password VARCHAR(200),
	INDEX (customer_id),
	INDEX (fname),
	INDEX (lname),
	INDEX (uname),
	INDEX (password),
	CONSTRAINT customers_pk PRIMARY KEY (customer_id) #, 
	#CONSTRAINT customers_accounts_fk  FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id)
);




###########################################################
################# POPULATE DATABASE #######################
###########################################################

INSERT INTO customers (customer_id, fname, lname, uname) VALUES (001,"Tony", "Stark", "Ironman");
INSERT INTO customers (customer_id, fname, lname, uname) VALUES (002,"Steve", "Rogers", "CaptinAmerica");
INSERT INTO customers (customer_id, fname, lname, uname) VALUES (003,"Bruce", "Banner", "Hulk");
INSERT INTO customers (customer_id, fname, lname, uname) VALUES (004,"Nick", "Fury", "Shield");
INSERT INTO customers (customer_id, fname, lname, uname) VALUES (005,"Clint", "Barker", "Hawkeye");
INSERT INTO customers (customer_id, fname, lname, uname) VALUES (006,"Peter", "Parker", "Spiderman");

#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);
#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);
#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);
#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);
#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);
#INSERT INTO %TableName (Filed1, field2) VALUES (v1, v2);