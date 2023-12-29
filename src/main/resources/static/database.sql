CREATE TABLE Person(
                       id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       username varchar(100) UNIQUE NOT NULL,
                       password varchar(100) NOT NULL,
                       role varchar(100) NOT NULL
);