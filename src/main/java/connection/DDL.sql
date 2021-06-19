CREATE DATABASE IF NOT EXISTS DB;

CREATE TABLE IF NOT EXISTS credentials
(
    id       int auto_increment primary key,
    login    varchar(20) not null,
    password varchar(20) not null
);
CREATE TABLE IF NOT EXISTS employees
(
    id        int auto_increment primary key,
    name1     varchar(100) not null,
    name2     varchar(100) not null,
    surname   varchar(100) not null,
    birthDate date         not null
);