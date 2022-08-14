# Readme

## Introduction

This project has been created using **Spring Boot 2.7.2**, **Java 11** and **Gradle** as its build tool.

## Running the application

In order to run the application, you can directly use Gradle's `bootrun` command from the root directory as follows:

```bash
./gradlew clean bootrun
```

## Compiling

Alternatively, you can create a JAR file with Gradle's `bootjar` command

```bash
./gradlew clean bootjar
```

and then execute it using the following command:

```bash
java -jar build/libs/termsearcher-1.0.0.jar
```

## Unit tests

There are unit tests available that can be run with:

```bash
./gradlew test
```

## Interacting with the endpoints

The two endpoints described in the assignment are available under 
- `termsearcher/quicksearch`: Returns a list of records matching the request parameter `term`
- `termsearcher/search`: Returns the same with the sum of hours of the records

In order to interact with them, following CURL commands can be used:

```bash
curl http://localhost:8080/termsearcher/search?term=COVID
```
```bash
curl http://localhost:8080/termsearcher/quicksearch?term=COVID
```

