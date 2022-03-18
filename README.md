

# Static Factory Method API - PERSON
API responsible for maintaining people and their addresses.

## Requisites

### Java 11
Java 11 can either be installed via the JDK contained on the [Oracle](https://www.oracle.com/java/technologies/downloads/) website or on the [OpenJDK](https://jdk.java.net/java-se-ri/11) website

Alternatively, you can use [SDKMan](https://sdkman.io/) and install Java.

### Maven (Optional)
Maven (optional)
The project was conceived so that the installation of Maven was optional, therefore, it is possible to run the project settings after installing Java through the files mvnw.cmd on Windows systems and mvnw on Unix systems, which interact with the maven-wrapper file. jar contained in the .mvn folder at the project root.

If you still want to run the project through Maven on the machine, it can be installed through the website.

Alternatively, you can use [SDKMan](https://sdkman.io/).

### Lombok (Optional)
[Lombok](https://projectlombok.org/) is a Java library that aims to reduce the verbosity of writing Getters, Setters, Constructors, toString, among other [features](https://projectlombok.org/features/all).

If you want to use it in your IDE, remember to configure it according to the following [instructions](https://projectlombok.org/setup/overview).

### Structure

    ├───.mvn
    │   └───wrapper
    ├───.settings
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───example
    │   │   │           └───demo
    │   │   │               ├───api
    │   │   │               │   ├───controller
    │   │   │               │   ├───mapper
    │   │   │               │   └───model
    │   │   │               │       ├───input
    │   │   │               │       └───output
    │   │   │               └───domain
    │   │   │                   ├───entities
    │   │   │                   ├───repositories
    │   │   │                   └───services
    │   │   └───resources
    │   └───test
    │       ├───java
    │       │   └───com
    │       │       └───example
    │       │           └───demo
    │       │               └───test
    │       │                   ├───integration
    │       │                   └───unit
    │       └───resources
    └───target
        ├───classes
        │   ├───com
        │   │   └───example
        │   │       └───demo
        │   │           ├───api
        │   │           │   ├───controller
        │   │           │   ├───mapper
        │   │           │   └───model
        │   │           │       ├───input
        │   │           │       └───output
        │   │           └───domain
        │   │               ├───entities
        │   │               ├───repositories
        │   │               └───services
        ├───generated-sources
        │   └───annotations
        │       └───com
        │           └───example
        │               └───demo
        │                   └───api
        │                       └───mapper
        ├───test-classes
        │   └───com
        │       └───example
        │           └───demo
        │               └───test
        │                   ├───integration
        │                   └───unit


### Architecture
- [Java 11](https://www.java.com/pt-BR/)
- [Lombok](https://projectlombok.org/)
- [Mapstruct](https://mapstruct.org/)
- [Maven](https://maven.apache.org/)
- [TestContainer](https://www.testcontainers.org/)
- [Spring Boot 2.6](https://spring.io/projects/spring-boot)

## Run Project
