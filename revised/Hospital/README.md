# Project Overview

Minimal Java Spring Boot application built with Maven. Contains the Spring Boot service, unit tests, and configuration files necessary to build, run, and test the application.

## Requirements

1. Java 11\+ (Java 17 recommended)
2. Maven 3.6\+
3. IntelliJ IDEA 2025.2.6 (Windows) or any compatible IDE/CLI

## Build and run

1. Build the project and run tests:
```bash
mvn clean install
```

2. Run from Maven:
```bash
mvn spring-boot:run
```

3. Run the packaged jar:
```bash
java -jar target/*.jar
```

## Run in IntelliJ

1. Open the project root in IntelliJ.
2. Wait for Maven import to finish.
3. Run the Spring Boot application from the main application class (in `src/main/java`) or use the Maven run configuration for `spring-boot:run`.

## Configuration

1. Application properties are in `src/main/resources/application.properties` (or `application.yml`).
2. Update database / external service settings in those files or via environment variables.

## Tests

1. Unit tests are located in `src/test/java`.
2. Run tests with:
```bash
mvn test
```

## Useful Maven commands

1. Clean:
```bash
mvn clean
```
2. Package:
```bash
mvn package
```
3. Run Spring Boot:
```bash
mvn spring-boot:run
```

## Project layout

1. `pom.xml` - Maven configuration and dependencies
2. `src/main/java` - application source code
3. `src/main/resources` - application configuration and static resources
4. `src/test/java` - unit and integration tests

## Contributing

1. Create a feature branch from `main`.
2. Add tests for new behavior.
3. Open a pull request with a clear description.