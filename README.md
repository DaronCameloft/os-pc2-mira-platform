# <PROJECT_NAME>

## Summary

<PROJECT_NAME> is a RESTful API developed with Java, Spring Boot, Maven, Spring Data JPA, and MySQL.
The application provides backend support for the <NOMBRE_CASO> case, exposing REST endpoints to manage <MAIN_RESOURCE_PLURAL>.

## Description

This project implements a backend service following Domain-Driven Design principles, layered architecture, bounded contexts, CQRS, REST resources, assemblers, and persistence with Spring Data JPA.

The main bounded context implemented in this project is `<BOUNDED_CONTEXT_NAME>`, which includes the management of `<MAIN_RESOURCE_NAME>`.

## Main Feature

The API implements the following operation:

* Create a new `<MAIN_RESOURCE_NAME>` using a POST endpoint.

## Endpoint

```http
POST <ENDPOINT_PATH>
```

Example:

```http
POST /api/v1/<RESOURCE_PATH>
```

## Request Body Example

```json
{
  "<FIELD_1>": "<VALUE_1>",
  "<FIELD_2>": "<VALUE_2>",
  "<FIELD_3>": "<VALUE_3>"
}
```

## Response Body Example

```json
{
  "id": 1,
  "<FIELD_1>": "<VALUE_1>",
  "<FIELD_2>": "<VALUE_2>",
  "<FIELD_3>": "<VALUE_3>"
}
```

## Technologies

* Java 26 JDK
* Spring Boot 4.1.0
* Maven
* Spring Web MVC
* Spring Data JPA
* MySQL
* Lombok
* Jakarta Validation
* Springdoc OpenAPI / Swagger UI

## Architecture

The project is organized using the following layers:

```text
<BASE_PACKAGE>
├── shared
│   ├── domain
│   ├── infrastructure
│   └── interfaces
└── <BOUNDED_CONTEXT_NAME>
    ├── domain
    ├── application
    ├── infrastructure
    └── interfaces
```

## Database

The application uses MySQL as relational database.

Database schema:

```text
<DATABASE_NAME>
```

Main table:

```text
<MAIN_TABLE_NAME>
```

## Swagger UI

After running the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

## Local Configuration

The application runs on port:

```text
8080
```

Development database configuration can be found in:

```text
src/main/resources/application-dev.properties
```

## Author

* Victor Paredes Maza
* U202416274
* Universidad Peruana de Ciencias Aplicadas
* Aplicaciones Open Source
