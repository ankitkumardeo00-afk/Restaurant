CREATE DATABASE restaurant_db;
USE restaurant_db;

CREATE TABLE food_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    category VARCHAR(50),
    price DOUBLE,
    available BOOLEAN
);
