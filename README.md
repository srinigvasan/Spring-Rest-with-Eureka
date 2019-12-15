# ND035-P02-VehiclesAPI-Project

Project repository for JavaND Project 2, where students implement a Vehicles API using Java and Spring Boot that can communicate with separate location and pricing services.

## Instructions

Check each component to see its details and instructions. Note that all three applications
should be running at once for full operation. Further instructions are available in the classroom.

- [Vehicles API](vehicles-api/README.md)
- [Pricing Service](pricing-service/README.md)
- [Boogle Maps](boogle-maps/README.md)

## Dependencies

The project requires the use of Maven and Spring Boot, along with Java 8.

#Setup Instructions

1. Package all components
    cd ${PROJECT_HOME}
    cd eureka; mvn package
    cd vehicles-api; mvn package
    cd pricing-service; mvn package
    cd boogle-maps; mvn package

2. Start individual services .  Follow this order. start Eureka Server first.
      - cd eureka; java -jar target/eureka-0.0.1-SNAPSHOT.jar
3. Start pricing service
     - cd pricing-service;java -jar target/pricing-service-0.0.1-SNAPSHOT.jar
4. Start vehicle services
     - cd vehicles-api;java -jar target/vehicles-api-0.0.1-SNAPSHOT.jar
5. start location service
     - cd boogle-maps;java -jar target/boogle-maps-0.0.1-SNAPSHOT.jar

6)  Please note on application start up .
      -    Price info is added for vehicle ID 1 to 20 in pricing-service.
      -    Manufacture info is also added on startup in vehicle-service
