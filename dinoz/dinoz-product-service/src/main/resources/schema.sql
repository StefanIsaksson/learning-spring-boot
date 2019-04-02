drop table if exists products;

create table products(
  ID varchar(100) not null,
  NAME varchar(100) not null,
  DESCRIPTION varchar(500) not null,
  PRICE decimal(10,2) not null,
  PRIMARY KEY ( ID )
);