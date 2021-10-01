#Rashid's First Super Awesome SQL DataBase!


DROP DATABASE IF EXISTS Banking_DB; #Delete Old DB
CREATE DATABASE Banking_DB; #Start New DB
USE Banking_DB; #Default DB

#Remove any old data
DROP TABLE IF EXISTS balances;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS accounts_customers;

#Begin creating tables for DB

CREATE TABLE accounts_customers 
(
	account_id 	INT NOT NULL ,
	customer_id INT NOT NULL,
	INDEX (account_id),
	INDEX (customer_id),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (account_id)
);

CREATE TABLE balances
(

    account_id 	INT NOT NULL,
    balance DECIMAL (10, 2),
    INDEX (account_id),
    INDEX (balance),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id), 
    CONSTRAINT accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);

CREATE TABLE customers 
(
	customer_id INT NOT NULL,
	fname VARCHAR(200),
	lname VARCHAR(200),
	uname VARCHAR(200),
	password VARCHAR(200),
	INDEX (customer_id),
	INDEX (fname),
	INDEX (lname),
	INDEX (uname),
	INDEX (password),
	CONSTRAINT customers_pk PRIMARY KEY (customer_id), 
	CONSTRAINT customers_accounts_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id));





################# POPULATE DATABASE #######################


INSERT INTO accounts_customers (customer_id, account_id) VALUES (0001, 900001);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0002, 900002);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0003, 900003);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0004, 900004);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0005, 900005);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0006, 900006);


INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (001,"Tony", "Stark", "Ironman","Pepper");
INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (002,"Steve", "Rogers", "CaptinAmerica","Peggy");
INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (003,"Bruce", "Banner", "Hulk","Betty");
INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (004,"Nick", "Fury", "Shield","Maria");
INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (005,"Clint", "Barker", "Hawkeye","Laura");
INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (006,"Peter", "Parker", "Spiderman","MaryJane");

INSERT INTO balances (account_id, balance) VALUES (900001, 15000000.50);
INSERT INTO balances (account_id, balance) VALUES (900002, 19450.25);
INSERT INTO balances (account_id, balance) VALUES (900003, 35000.56);
INSERT INTO balances (account_id, balance) VALUES (900004, 67433.00);
INSERT INTO balances (account_id, balance) VALUES (900005, 10000.01); 
INSERT INTO balances (account_id, balance) VALUES (900006, 12.67);

#####################ACTIOMS#############################


SELECT c.uname, CONCAT(c.fname, " ", c.lname) AS "NAME & ID", b.balance 
FROM customers c 
JOIN accounts_customers ac ON c.customer_id = ac.customer_id
JOIN balances b ON ac.account_id = b.account_id;





