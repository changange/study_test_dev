drop database if exists mybatis;
create database mybatis charset utf8;
use mybatis;

create table t_user
(
    id int primary key auto_increment,
    username varchar(50) unique not null,
    password varchar(100),
    phone varchar(30),
    address varchar(100)
)charset utf8;

create table t_user2
(
    user_id int primary key auto_increment,
    user_username varchar(50) unique not null,
    user_password varchar(100),
    user_phone varchar(30),
    user_address varchar(100)
)charset utf8;
insert into t_user2 values (null,'admin','123','13888888888','南京');


create table t_dept
(
    id int primary key auto_increment,
    name varchar(50)
)charset utf8;

create table t_emp
(
    id int primary key auto_increment,
    name varchar(30),
    salary double,
    dept_id int,
    foreign key (dept_id) references t_dept(id)
)charset utf8;
