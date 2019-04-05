drop table if exists customers;

create table customers(
  ID varchar(100) not null,
  NAME varchar(100) not null,
  ADDRESS varchar(200) not null,
  PHONE varchar(100) null,
  PRIMARY KEY ( ID )
);