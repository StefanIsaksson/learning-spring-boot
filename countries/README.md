# Countries REST-API

## Uses
- **[Spring Boot](https://expressjs.com/)**, framework designed to make it easier to develop a new Spring applications
- **[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)**, a java web application framework
- **[Spring Data](http://spring.io/projects/spring-data-jpa)**, java library used to simplify implementing data access layer.
- **[SQLite](https://www.sqlite.org/index.html)**, a SQL database

## API

|Service                             |Type  |Description                   |
|------------------------------------|------|-------------------------------
|api/v1/countries                    |GET   |List all countries            |
|api/v1/countries/**id**             |GET   |Retrieve country by id        |
|api/v1/countries                    |POST  |Create new country            |

# Install

## Prerequisite
- SQLite Command-Line Shell [sqlite3.exe](https://www.sqlite.org/download.html) installed and available under PATH

## Create database, tables and insert data
In the project directory run:
`> sqlite3 country.db`
and then:
`sqlite3> .read create.sql`

## Useful SQLite commands

| command                                 | description                                               |
| --------------------------------------- | --------------------------------------------------------- |
| > sqlite3 -version                      | show version                                              |
| > sqlite3 country.db                    | switch to database country (create country.db if missing) |
| > sqlite3 country.db .dump > create.sql | export database content to sql-file                       |
| sqlite3> .read create.sql               | run create.sql file inside database                       |
| sqlite3> .quit                          | exit SQLite CLI                                           |