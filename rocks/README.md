# CRUD REST-API using Spring Boot, Spring MVC, Flyway, JPA and H2

## API

|Service                          |Type  |Description                                             |
|---------------------------------|------|--------------------------------------------------------
|api/v1/rocks                     |GET   |Lists all rocks                                         |
|api/v1/rocks<id>                 |GET   |Retrives on rock by id                                  |
|api/v1/rocks<id>                 |POST  |Creates new rock                                        |
|api/v1/rocks<id>                 |PUT   |Updates existing rock by id                             |
|api/v1/rocks<id>                 |DELETE|Delete rock by id                                       |


## H2 database management

After starting application the h2 database can be managed through following web client url:
http://localhost:8080/h2/

# Database content

The database will contain several rock with descriptions. The goal is to fill the database with the following common rocks.
Currently only a few rocks have been added. Those which exist are marked with (Included)

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
- shale
- siltstone
- turbidite