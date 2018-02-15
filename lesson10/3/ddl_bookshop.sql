create database bookshop;
use bookshop;

create table book(
	id_book int not null auto_increment,
    name varchar(45) not null,
    price float, 
    status char(1) not null, 
    year_of_publication int,
    date date,
    primary key(id_book)
);

create table orders(
	id_order int not null auto_increment,
    id_book int,
    date_of_deliver date ,
    order_status varchar(50) not null,
    primary key(id_order),
    foreign key(id_book) references book(id_book) on delete cascade on update cascade
);

create table requests(
	id_request int not null auto_increment,
    id_book int,
    primary key(id_request),
    foreign key(id_book) references book(id_book) on delete cascade on update cascade
);
    