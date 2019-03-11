# REST-API using Spring Boot, Spring MVC and ActiveMQ
The focus is on learning ActiveMQ.

## Uses
- **[Spring Boot](https://expressjs.com/)**, framework designed to make it easier to develop a new Spring applications
- **[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)**, a java web application framework
- **[Spring JMS](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/jms.html)**, simplifies the use of the JMS API (like Spring JDBC does for JDBC API).
- **[ActiveMQ](http://activemq.apache.org/)**, a message broker and a Java Message Service (JMS) client.
- **[iText](https://itextpdf.com/en/)**, a library for creating and manipulating PDF files in Java and .NET.
- **[Spring JDBC](https://spring.io/projects/spring-data-jdbc)**, (a part of Spring Data) used to simplify implementing data access layer.
- **[SQLite](https://www.sqlite.org/index.html)**, a SQL database
- **[Flyway](https://flywaydb.org/)**, version control for database migrations.

## API
|Service                             |Type  |Description                   |
|------------------------------------|------|-------------------------------
|/**fileName**                       |GET   |Get invoice PDF file          |
|api/v1/invoice                      |GET   |Lists all invoices fileNames  |

## Prerequisite
acttiveMQ installed and running locally on default port 61616 (listening).

#### Install ActiveMQ
Download [ActiveMQ](http://activemq.apache.org/download.html)

Extract the files from the ZIP file into a directory of your choice (i.e `C:\tools\activemq`\).

#### Start ActiveMQ

Open a console window in the acttiveMQ base directory and run:
`bin\activemq start`

ActiveMQ logs are found in .\data directory

#### Monitor and administrate ActiveMQ

1. Go to http://localhost:8161/admin (username and password is admin/admin)
