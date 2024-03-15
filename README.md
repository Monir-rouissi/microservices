# Microservice Project using Spring Cloud
## Description
This project demonstrates a practical microservices architecture using Spring Cloud. It covers various aspects of a microservice architecture including service discovery, centralized configuration, distributed tracing, circuit breaker patterns, and event-driven architecture.

This project consists of three separate microservices: Order Service, Product Service, and Inventory Service. Each service is designed to run independently and communicates with its own database.


### Order Service

The Order Service uses MySQL as its database.

```bash
# Navigate to the Order Service directory
cd order-service

# Run the service using Maven
mvn spring-boot:run

## Prerequisites

- Java JDK 19 or later
- Maven 3.2 or later
- MySQL (for Order Service)
- PostgreSQL (for Product Service and Inventory Service)


## Features

- **Service Discovery**: Implemented using Spring Cloud's Eureka Server, allowing microservices to register themselves and discover other services.
- **Centralized Configuration**: Managed through Spring Cloud Config Server, providing a central place for externalized configuration in a distributed system.
- **Distributed Tracing**: Integrated with Spring Cloud Sleuth and Zipkin for distributed tracing to help debug and understand the system's behavior.
- **Circuit Breaker**: Utilizes the Hystrix library to implement the Circuit Breaker pattern, which helps to prevent system failure and ensure continued operation.
- **Event-Driven Architecture**: Leverages Spring Cloud Stream to create an event-driven architecture.
```markdown
# Project Title

Microservice using Spring Boot, Maven, and Java 19

### Installing

* Install Java 19 from the official Oracle website.
* Install Maven from the official Apache Maven website.
* Spring Boot does not require any installation. It will be downloaded by Maven.

### Executing program

* To compile the project, navigate to the project directory and run the following command:
```bash
mvn clean install
```
* To run the project, use the following command:
```bash
mvn spring-boot:run
```

## Help

If you encounter any problems, please open an issue in the issue tracker.

## Authors

Mounir Rouissi  
mounirrouissi2@gmail.com

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the MIT  License - see the LICENSE.md file for details

## Links

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Java 19](https://www.oracle.com/java/technologies/javase-jdk19-downloads.html)
```
