CREATE DATABASE mydb4;

use mydb4;

CREATE TABLE Customers SELECT * FROM w3schools.Customers;
DESC Customers;
ALTER TABLE Customers MODIFY COLUMN CustomerID INT PRIMARY KEY AUTO_INCREMENT;


CREATE TABLE Employees SELECT * FROM w3schools.Employees;
DESC Employees;
ALTER TABLE Employees MODIFY COLUMN EmployeeID INT PRIMARY KEY AUTO_INCREMENT;

SELECT * FROM Customers; -- 91개
SELECT * FROM Employees; -- 10개

