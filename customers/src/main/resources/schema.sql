drop table if exists customers;

create table customers(
  ID INT not null,
  CUSTOMERID varchar(20) not null,
  MARITAL_STATUS varchar(100) null,
  NAME varchar(100) not null,
  SCORE DECIMAL(4, 2) null,
  PARTNER_NAME varchar(100) null,
  INCOME INT not null,
  LAST_UPDATED TIMESTAMP null,
  ADDRESS varchar(100) null,
  PRIMARY KEY ( ID )
);