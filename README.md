# Spring Data JPA Boilerplate (REST)
This project is a boilerplate for Spring Boot's Data JPA. This project is meant to
be used as backend for applications that adhere to the REST Api. It comes with the
following features:

- A relational Database that is worked with using *Spring Data Jpa*
- REST endpoints managed by Spring Controllers
- Automated tests
- Thorough documentation

## Description
This application runs with Gradle. Hence, it comes with two source
directories:
- `src/main` contains the main application context
- `src/test` contains all automated tests for the main application

### Main
The main application comes with the following structure:

- `config`: Contains additional configurations for the Spring application
- `controllers`: Contains the controllers that manage endpoints for the REST Api
- `entities`: Contains all entities for the *Java Persistence Api*
- `repositories`: Contains all Spring JPA repositories that act as DAOs
- `MyApplication.java`: The main application

Please refer to the official Javadoc for more information.

### Test
The tests inherit the structure of the main application context, so as to
maintain a coherent structure. The tests utilize Java's H2 database and are
independent of the main database. The tests entail Unit Tests for the individual
controllers and repositories and Integration Tests for the REST Api as
well.

## Usage
After downloading this project rename elements in the `settings.gradle` and in the
`build.gradle`, such as the project name and author, to match your requirements.
Do the same for any packages under `src`. Also, make sure to edit properties under
the `src/main/resources/application.properties` file to establish a connection to
your database. Additionally, you should change the aforementioned Spring configurations,
such as the Web Security, to fit your needs.

### Commands
On Linux / MacOS:
- `./gradlew build`: Builds the project
- `./gradlew javadoc`: Generates the Javadoc documentation
- `./gradlew test`: Runs all the JUnit tests
- `./gradlew bootRun`: Runs the application context

On Windows:
- `gradlew build`: Builds the project
- `gradlew javadoc`: Generates the Javadoc documentation
- `gradlew test`: Runs all the JUnit tests
- `gradlew bootRun`: Runs the application context

## Requirements
In order to use this project, you need the following requirements:
- Java 11 or above
- Gradle
