CREATE DATABASE homework_39;

USE Homework_39;

CREATE TABLE products(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50),
cost FLOAT,
PRIMARY KEY(id)
);

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (email)
);

CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT,
  role VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users_roles(
users_id INT NOT NULL ,
roles_id INT NOT NULL,
FOREIGN KEY(users_id) REFERENCES users(id),
FOREIGN KEY(roles_id) REFERENCES roles(id)
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

INSERT INTO users(email,username,password)
VALUES('frank.com','Frank','p@ss'),
('bob.com','Bob','p@ss'),
('kate.com','Kate','pass'),
('michael.com','Michael','pass'),
('bob2.com','Bob','pass'),
('jimmy.com','Jimmy','pass');

INSERT INTO roles(role)
VALUES('ADMIN'),
('USER');

INSERT INTO users_roles(users_id,roles_id)
VALUES(1,1),
(2,1),
(3,2),
(4,2),
(5,2),
(6,2);