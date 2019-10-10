DROP DATABASE if exists InventoryDB;
CREATE DATABASE InventoryDB;

USE InventoryDB;

DROP TABLE if exists user_table;

    CREATE TABLE if not exists user_table(
        active boolean NOT NULL default '1',
        email VARCHAR(40) NOT NULL UNIQUE,
        fname VARCHAR(20),
        lname VARCHAR(20),
        password VARCHAR(20),
        PRIMARY KEY (email),
        CHECK (password = 'password')
);


INSERT INTO user_table (active, email, fname, lname, password)
    VALUES ('1', 'admin@admin.com', 'First', 'Last', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES ('1', 'arran.woodruff@sait.edu.ca', 'Arran', 'Woodruff', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES ('1', 'david.ward@sait.edu.ca', 'David', 'Ward', 'password');

INSERT INTO user_table (active, email, fname, lname, password)
    VALUES ('1', 'steven.wong01@sait.edu.ca', 'Steven', 'Wong', 'password');