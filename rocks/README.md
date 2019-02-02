# CRUD REST-API using Spring Boot, Spring MVC, Flyway, JPA and H2

## Uses
- **[Spring Boot](https://expressjs.com/)**, framework designed to make it easier to develop a new Spring applications
- **[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)**, a java web application framework
- **[Flyway](https://flywaydb.org/)**, version control for database migrations.
- **[Spring Data](http://spring.io/projects/spring-data-jpa)**, java library used to simplify implementing data access layer.
- **[H2](http://www.h2database.com/html/main.html)**, a Java SQL database

## API

|Service                             |Type  |Description                   |
|------------------------------------|------|-------------------------------
|api/v1/rocks                        |GET   |List all rocks                |
|api/v1/rocks/**id**                 |GET   |Retrive rock by id            |
|api/v1/rocks/**id**                 |POST  |Create new rock               |
|api/v1/rocks/**id**                 |PUT   |Replace existing rock by id   |
|api/v1/rocks/**id**                 |PATCH |Update existing rock by id    |
|api/v1/rocks/**id**                 |DELETE|Delete rock by id             |

## H2 database management

After starting application the h2 database can be managed through following web client url:
http://localhost:8080/h2/

## Content

The database will contain several rock with descriptions. The goal is to fill the database with the following common rocks.
Currently only a few rocks have been added. Those which exist are marked with (Included)

### Example data:

```json
{
    "id": 2,
    "name": "Basalt",
    "rockType": "IGNEOUS_ROCKS",
    "visualDescription": "Dark-colored (usually black) and fine-grained",
    "pictureUrl": "",
    "rockFormation": "Basalt forms when lava reaches the Earths surface at a volcano or mid ocean ridge. It is fine-grained because of its rapid cooling.",
    "mineralComposition": "Basalt is mainly composed of olivine and pyroxene minerals.",
    "location": "Basalt underlies more of Earths surface than any other rock type. Much more under the oceans than on continents.",
    "mohsScale": 6
}
```

## List of common rocks

### igneous rocks

- granite (included)
- andesite
- basalt (included)
- dacite
- dolerite
- gabbro
- diorite
- peridotite
- nepheline
- obsidian
- scoria
- tuff
- volcanic bomb

### metamorphic rocks 

- amphibolite
- schist
- eclogite
- gneiss
- hornfels
- marble
- migmatite
- phyllite
- quartzite
- serpentinite
- slate

### sedimentary Rocks

- argillite
- breccia
- chalk
- chert
- claystone
- coal
- conglomerate
- dolomite
- limestone
- gypsum
- greywacke
- mudstone
- shale (included)
- siltstone
- turbidite