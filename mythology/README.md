# REST-API using Spring Boot, Spring MVC, Spring JDBC and mySQL

The focus is on learning Spring JDBC.

## Uses
- **[Spring Boot](https://expressjs.com/)**, framework designed to make it easier to develop a new Spring applications
- **[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)**, a java web application framework
- **[Spring JDBC](https://spring.io/projects/spring-data-jdbc)**, (a part of Spring Data) used to simplify implementing data access layer.
- **[mySQL](https://www.mysql.com/)**, an Open Source SQL database

## API

|Service                             |Type  |Description                   |
|------------------------------------|------|-------------------------------
|api/v1/gods                         |GET   |List all gods                 |
|api/v1/gods                         |POST  |Create new god                |

## Prerequisite
mySQL installed and running locally on port 3306.

## Install database schema
Using [MySQL Workbench](https://www.mysql.com/products/workbench/) log in as root and run [create_db_schema.sql](./create_db_schema.sql).