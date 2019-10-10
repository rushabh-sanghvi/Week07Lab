DROP DATABASE if exists InventoryDB;
CREATE DATABASE InventoryDB;

USE InventoryDB;

DROP TABLE if exists user_table;

    CREATE TABLE if not exists user_table(
        email VARCHAR2(40),
        fname VARCHAR2(20),
        lname VARCHAR2(20),
        password VARCHAR2(20));

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES (1, 'admin@admin.com', 'First', 'Last', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES (1, 'arran.woodruff@sait.edu.ca', 'Arran', 'Woodruff', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES (1, 'david.ward@sait.edu.ca', 'David', 'Ward', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES (1, 'steven.wong01@sait.edu.ca', 'Steven', 'Wong', 'password');