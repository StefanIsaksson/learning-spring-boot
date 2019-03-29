# Dinoz, Microservices with API Gateway 
(Apps for a fictive company thay sells dinosaurs).
Built to learn about Spring Cloud and microservices in general.

# dinoz-configuration-server (and dinoz-configuration)
Reads configuration from a git repository and provides it to external Apps.

### Uses:
- **[Spring Cloud Config](https://spring.io/projects/spring-cloud-config)**, a central place to manage external properties for applications across all environments

## API

|Service                             |Type  |Description                             |
|------------------------------------|------|-----------------------------------------
|/gateway/default                    |GET   |Retrieve gateway configuration          |
|/service-discovery/default          |GET   |Retrieve service-discovery configuration|
|/product-service/default            |GET   |Retrieve product-service configuration  |
|/order-service/default              |GET   |Retrieve order-service configuration    |

*App runs default on http://localhost:8082

### Install:
Copy folder `dinoz-configuration` to `${user.home}`

Open to folder in command line and type:
```
git init
git add .
git commt -m "Initial commit"
```
For changes to take effect they need to be commited in git.

### Run:
`ConfigApplication.java`

# dinoz-service-discovery

### Uses:
- **[Spring Cloud Netflix Eureka](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#_service_discovery_eureka_clients)**, a service registry for resilient load balancing and failover.

## API

|Service                             |Type  |Description                          |
|------------------------------------|------|--------------------------------------
|/                                   |GET   |HTML Page listing registered services|

*App runs default on http://localhost:8082 (configured in dinoz-configuration)*

### Run:
`ServiceDiscoveryApplication.java`

(**Prerequisite:** Running dinoz-configuration-server)

# dinoz-gateway

### Uses:
- **[Spring Cloud Netflix Zuul](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html#_router_and_filter_zuul)**, a JVM-based router and server-side load balancer.

## API

|Service                             |Type  |Description                        |
|------------------------------------|------|------------------------------------
|product-service/products            |GET   |List all products                  |
|product-service/products/**id**     |GET   |Retrieve product  by id            |
|product-service/products            |POST  |Create new product                 |
|product-service/products/**id**     |PUT   |Replace existing product by id     |
|product-service/products/**id**     |DELETE|Delete products by id              |
|order-service/orders                |GET   |List all orders                    |
|order-service/orders/**id**         |GET   |Retrieve order by id               |
|order-service/orders                |POST  |Create new order                   |
|order-service/orders/**id**         |PUT   |Replace existing order by id       |
|order-service/orders/**id**         |DELETE|Delete order by id                 |

*App runs default on http://localhost:8080 (configured in dinoz-configuration)*


### Run:
`GatewayApplication.java`
   
(**Prerequisite:** Running dinoz-service-discovery)

# dinoz-product-service

### Run:
`ProductServiceApplication.java`
   
(**Prerequisite:** Running dinoz-service-discovery)

## API

|Service             |Type  |Description                        |
|--------------------|------|------------------------------------
|products            |GET   |List all products                  |
|products/**id**     |GET   |Retrieve products by id            |
|products            |POST  |Create new products                |
|products/**id**     |PUT   |Replace existing products by id    |
|products/**id**     |DELETE|Delete products by id              |

*App runs default on http://localhost:8083 (configured in dinoz-configuration)*

# dinoz-order-service

### Run:
`OrderServiceApplication.java`
   
(**Prerequisite:** Running dinoz-service-discovery)

## API

|Service             |Type  |Description                        |
|--------------------|------|------------------------------------
|orders              |GET   |List all orders                    |
|orders/**id**       |GET   |Retrieve order by id               |
|orders              |POST  |Create new order                   |
|orders/**id**       |PUT   |Replace existing order by id       |
|orders/**id**       |DELETE|Delete order by id                 |

*App runs default on http://localhost:8084 (configured in dinoz-configuration)*

# dinoz-shop-webapp

A simple Web App.

### Uses:
- **[Vaadin](https://vaadin.com/)**, a web framework that allows creating HTML5 web user interfaces using the Java language.

## API

|Service                             |Type  |Description                                |
|------------------------------------|------|--------------------------------------------
|/                                   |GET   |HTML Page calling Dinoz gateway API        |

*App runs default on http://localhost:80 (configured in dinoz-configuration)*

### Run:
`ShopApplication.java`

(**Prerequisite:** Running dinoz-gateway)