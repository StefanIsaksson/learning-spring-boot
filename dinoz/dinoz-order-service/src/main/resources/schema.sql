drop table if exists orders;

create table orders(
  ID varchar(100) not null,
  CUSTOMER_ID varchar(100) not null,
  SHIPPING_ADDRESS varchar(500) not null,
  ORDER_STATUS varchar(500) not null,
  PRIMARY KEY ( ID )
);

create table products(
  ID varchar(100) not null,
  NAME varchar(100) not null,
  PRICE decimal(10,2) not null,
  FK_ORDERS varchar(100) not null,
  PRIMARY KEY ( ID ),
  foreign key (FK_ORDERS) references orders(ID)
);