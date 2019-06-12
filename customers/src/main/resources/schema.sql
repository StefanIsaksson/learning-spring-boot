drop table if exists customers;

create table customers(
  ID INT not null,
  NAME varchar(100) not null,
  CUSTOMERID varchar(20) not null,
  SCORE DECIMAL(4, 2) null,
  INCOME INT null,
  PARTNER_NAME varchar(100) null,
  PRIMARY KEY ( ID )
);