drop database if exists ums;

create database ums;
use ums;

create table t_user
(
    id int primary key auto_increment,
    username varchar(200) not null unique ,
    password varchar (200),
    age int
) engine=Innodb charset utf-8