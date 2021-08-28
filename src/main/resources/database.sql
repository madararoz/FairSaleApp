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