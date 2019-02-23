# Webb app using Spring Boot, Spring MVC, Spring JDBC, mySQL and JSP

The focus is on learning Spring MVC and JSP.

## Uses
- **[Spring Boot](https://expressjs.com/)**, framework designed to make it easier to develop a new Spring applications
- **[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)**, a java web application framework
- **[Spring JDBC](https://spring.io/projects/spring-data-jdbc)**, (a part of Spring Data) used to simplify implementing data access layer.
- **[mySQL](https://www.mysql.com/)**, an Open Source SQL database
- **[JSP](https://www.oracle.com/technetwork/java/index-jsp-138231.html/)**, Technology from 1999 used to create dynamically generated web pages.

## HTML URL:
http://localhost:8080/ 

## REST API

|Service                             |Type  |Description                   |
|------------------------------------|------|-------------------------------
|api/v1/epochs                       |GET   |List all epochs               |
|api/v1/periods                      |GET   |List all periods              |

## Prerequisite
mySQL installed and running locally on port 3306.

## Install database schema
Using [MySQL Workbench](https://www.mysql.com/products/workbench/) log in as root and run [create_db_schema.sql](./create_db_schema.sql).