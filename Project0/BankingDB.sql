#########Avengers SQL DataBase############


DROP DATABASE IF EXISTS Banking_DB; #Delete Old DB
CREATE DATABASE Banking_DB; #Start New DB
USE Banking_DB; #Default DB

#Remove any old tables
DROP TABLE IF EXISTS balances;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS accounts_customers;

#Begin creating tables for DB
CREATE TABLE accounts_customers 
(
	account_id 	INT AUTO_INCREMENT,
	customer_id INT NOT NULL,
	INDEX (account_id),
	INDEX (customer_id),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (account_id)
);

CREATE TABLE balances
(
    account_id 	INT AUTO_INCREMENT,
    balance DECIMAL (10, 2),
    INDEX (account_id),
    INDEX (balance),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id), 
    CONSTRAINT accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);

CREATE TABLE customers 
(
	customer_id INT AUTO_INCREMENT,
	fname VARCHAR(200),
	lname VARCHAR(200),
	uname VARCHAR(200),
	password VARCHAR(200),
	email VARCHAR(200),
	INDEX (customer_id),
	INDEX (fname),
	INDEX (lname),
	INDEX (uname),
	INDEX (password),
	INDEX (email),
	CONSTRAINT customers_pk PRIMARY KEY (customer_id), 
	CONSTRAINT customers_accounts_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id));




################# POPULATE DATABASE #######################


INSERT INTO accounts_customers (customer_id, account_id) VALUES (0001, 900001);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0002, 900002);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0003, 900003);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0004, 900004);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0005, 900005);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (0006, 900006);

INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (001,"Tony", "Stark", "Ironman","Pepper", "Ironman@Avengers.com");
INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (002,"Steve", "Rogers", "CaptainAmerica","Peggy", "CaptainAmerica@Avergers.com");
INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (003,"Bruce", "Banner", "Hulk","Betty","Hulk@Avengers.com");
INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (004,"Nick", "Fury", "Shield","Maria", "Shield@Avengers.com");
INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (005,"Clint", "Barker", "Hawkeye","Laura", "Hawkeye@Avengers.com");
INSERT INTO customers (customer_id, fname, lname, uname, password, email) VALUES (006,"Peter", "Parker", "Spiderman","MaryJane", "Spiderman@Avengers.com");

INSERT INTO balances (account_id, balance) VALUES (900001, 15000000.50);
INSERT INTO balances (account_id, balance) VALUES (900002, 19450.25);
INSERT INTO balances (account_id, balance) VALUES (900003, 35000.56);
INSERT INTO balances (account_id, balance) VALUES (900004, 67433.00);
INSERT INTO balances (account_id, balance) VALUES (900005, 10000.01); 
INSERT INTO balances (account_id, balance) VALUES (900006, 12.67);


#####################ACTIOMS#############################

#Update balances b 
#JOIN accounts_customers ac ON ac.account_id = b.account_id 
#JOIN customers c ON c.customer_id = ac.customer_id 
#SET balance = (balance + 12) 
#WHERE uname = "Hulk";

#INSERT INTO customers c (customer_id, fname, lname, uname, password) 
#VALUES (007,"Steven", "Strange", "Dr.Strange","Christine");

DELETE From customers 
WHERE email NOT LIKE '%_@__%.___%'; 


SELECT c.uname AS "Username", CONCAT(c.fname, " ", c.lname) AS "NAME & ID", b.balance AS "Balance", c.password, c.email, c.customer_id 
FROM customers c 
JOIN accounts_customers ac ON c.customer_id = ac.customer_id
JOIN balances b ON ac.account_id = b.account_id;

#SELECT balance
#FROM balances b
#JOIN accounts_customers ac ON  ac.account_id = b.account_id 
#JOIN customers c ON  c.customer_id = ac.customer_id
#WHERE c.uname = "";


# Here is an example of a query that can be used to figure out the next ID you want to use when 
# doing inserts into accounts, customers, and junction table

#SELECT * 
#FROM accounts_customers ac 
#ORDER BY account_id DESC 
#LIMIT 1

#SELECT * 
#FROM  customers c 
#ORDER BY customer_id DESC 
#LIMIT 1

# This gets you the greatest ID in the list, and all your have to do is now add 1 to it for your insert statement.
# Then just keep that id until you do the inserts into other tables and use that ID to link the foreign keys - 

# Do this logic in java, and marshall the objects with constructors or setters, and then we can send the object 
# over to the CRUD methods to be inserted. 

# When doing this, get the next available id's from the tables with a query like above, and just store these ids in the objects.
# So for instance, create a new customer object, set fname, set lname, set uname and password, then query for the 
# greatest ID in the table with a query like the one written above, add 1 to that number, and that's your customer_id, 
# then use another setter to put into the object.
