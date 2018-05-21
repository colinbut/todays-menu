# Todays Menu

This is a simple web application that displays the food menu for today.
 
### Tech Stack
 
- Java 8
- H2 DB
- Hibernate
- Spring Boot
- Spring Data JPA
- Thymeleaf (template engine)
- HTML/CSS/JS - Bootstrap & JQuery

other third party libraries:

- Lombok
- JodaTime
- WebJars
 
### Run Locally

```bash
./mvnw spring-boot:run
```

### Local Development

You can log on to the Database to inspect it during development. 

This application currently uses H2 as an embedded database.

To check the Database, you can fire up the H2 console from:

http://localhost:8080/h2-console

port 8080 of the app is the default port (left untouched from default configurations)

then enter the H2 DB Url as:

__jdbc:h2:mem:testdb__

leave username as it is and password blank.

### Demo

The demo web app is deployed onto ...

You can visit the web app here:

[TBD]

