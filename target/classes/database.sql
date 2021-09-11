




 SELECT id, product_type, price, count, gender, produce_type, size, colour, type_name from items;

 DELETE from items where id=1;


 SELECT product_type, price, count, (price*count) AS total_price from items;

 alter table items add total_price double;

 //alter table items ADD [total] as (price * count);
 UPDATE items set total_price = price * count;

drop table orders;

SET GLOBAL time_zone = '+3:00';

create table if not exists orders(
	id int primary key auto_increment not null,
    product_type text (50) not null,
    price int not null,
    count int not null,
    gender varchar(10) not null,
    produce_type varchar(20) not null,
    size varchar(10) not null,
    colour varchar(30) not null,
    type_name varchar(20) not null,
    customer_name varchar(50) not null,
    customer_email varchar(50) not null,
    customer_phone int not null,
    delivery_method varchar(20) not null,
    created_at timestamp default current_timestamp,
    );



create table if not exists items(
	id int primary key auto_increment not null,
    product_type text (50),
    price int not null,
    count int not null,
    gender varchar(10) not null,
    produce_type varchar(20) not null,
    size varchar(10) not null,
    colour varchar(30) not null,
    type_name varchar(20) not null
    );


create database fairsales;

use fairsales;

create table if not exists gender_of_use(
	id int primary key auto_increment not null,
    gender varchar(10) not null
    );

create table if not exists type_of_produce(
	id int primary key auto_increment not null,
    produceType char not null
    );
    drop table type_of_produce;

create table if not exists type_of_product(
	id int primary key auto_increment not null,
    productType varchar(20) not null
    );

create table if not exists items(
	id int primary key auto_increment not null,
    price int not null,
    genderId int not null,
    size varchar(10) not null,
    colour varchar(30) not null,
    type_name text(50),
    mark_as_sold char not null,
    produceId int,
    productId int,
    foreign key(produceId) references type_of_produce(id),
    foreign key(productId) references type_of_product(id),
    foreign key(genderId) references gender_of_use(id)
    );



create table if not exists customer(
	id int primary key auto_increment not null,
    name varchar(50) not null,
    phone int not null,
    email varchar(50),
    delivery_method text,
    orderId int not null,
	foreign key(orderId) references items(id)
    );

