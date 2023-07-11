CREATE DATABASE homework_39;

USE Homework_39;

CREATE TABLE products(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50),
cost FLOAT,
PRIMARY KEY(id)
);

CREATE TABLE users(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50)NOT NULL,
password VARCHAR(60)NOT NULL,
role VARCHAR(50)NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO products(name,cost)
VALUES('coffee',10),
('tea',5),
('hot dog',20),
('cake',15),
('sandwich',15),
('water',2),
('ice tea',8),
('juice',12),
('lemonade',17),
('ice cream',16);

INSERT INTO users(name,password,role)
VALUES('Frank','p@ss','Admin'),
('Jack','p@ss','Admin'),
('Kate','pass','User'),
('John','pass','User'),
('Jack','pass','User');
