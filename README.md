# Simple Task Management Backend

A RESTful Task Management API built with **Java, Spring Boot, Spring Data JPA, and MySQL**. This project demonstrates layered backend architecture, CRUD operations, DTO-based data transfer, request validation, and centralized exception handling.

## Features

- **Task CRUD Operations** — Create, retrieve, update, and delete tasks.
- **Bulk Task Creation** — Create multiple tasks using `saveAll()` from Spring Data JPA.
- **DTO-Based API** — Separate request and response objects using `TaskRequest` and `TaskResponse`.
- **Database Integration** — Persist task data in MySQL using Spring Data JPA and Hibernate.
- **Request Validation** — Validate task titles using `@NotBlank` and `@Valid`.
- **Global Exception Handling** — Handle missing tasks and return structured error responses.
- **Layered Architecture** — Separate controllers, services, repositories, entities, DTOs, and exception handling.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming language |
| Spring Boot | Application framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database access |
| Hibernate | ORM implementation |
| MySQL | Relational database |
| Maven | Dependency management and build |
| Postman | API testing |

## Architecture

```text
Client / Postman
       |
       v
TaskController
       |
       v
TaskService
       |
       v
TaskServiceImpl
       |
       v
TaskRepository
       |
       v
MySQL Database
```

Supporting components:

- `TaskRequest` and `TaskResponse` — API data transfer objects
- `TaskNotFoundException` — custom exception for missing tasks
- `GlobalExceptionHandler` — centralized error handling

## API Endpoints

Base URL: `http://localhost:8080/api/v1/tasks`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/tasks` | Create a task |
| POST | `/api/v1/tasks/bulk` | Create multiple tasks |
| GET | `/api/v1/tasks` | Retrieve all tasks |
| GET | `/api/v1/tasks/{id}` | Retrieve a task by ID |
| PUT | `/api/v1/tasks/{id}` | Update a task |
| DELETE | `/api/v1/tasks/{id}` | Delete a task |

## Getting Started

### Prerequisites

- Java 17 or a compatible version for your project
- Maven
- MySQL Server
- Postman (optional, for API testing)

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/Simple-Task-Management-Backend.git
cd Simple-Task-Management-Backend
```

Replace `YOUR_USERNAME` with your GitHub username and adjust the repository URL if needed.

### 2. Create the MySQL database

Connect to MySQL and execute:

```sql
CREATE DATABASE task_management;
```

### 3. Configure application properties

In `src/main/resources/application.properties`, configure your database connection:

```properties
spring.application.name=taskManagement

spring.datasource.url=jdbc:mysql://localhost:3306/task_management
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Set the `DB_PASSWORD` environment variable to your MySQL password before starting the application. Do not commit database credentials to GitHub.

### 4. Run the application

Using the Maven wrapper, if included:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Alternatively, run the main application class from IntelliJ IDEA.

## Example Requests

### Create a task

**POST** `/api/v1/tasks`

```json
{
  "title": "Learn Spring Boot",
  "description": "Build a Task Management API",
  "completed": false
}
```

### Create multiple tasks

**POST** `/api/v1/tasks/bulk`

```json
[
  {
    "title": "Learn Java",
    "description": "Practice object-oriented programming",
    "completed": false
  },
  {
    "title": "Practice SQL",
    "description": "Learn joins and aggregation",
    "completed": true
  }
]
```

### Example response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Build a Task Management API",
  "completed": false,
  "createdAt": "2026-10-25T18:00:00"
}
```

The ID and timestamp are illustrative; actual values depend on the saved record and application clock.

## Error Handling

The API is designed to provide meaningful HTTP responses for common scenarios.

| Status | Meaning |
|---|---|
| `201 Created` | Task created successfully |
| `200 OK` | Retrieval or update successful |
| `204 No Content` | Task deleted successfully |
| `400 Bad Request` | Invalid request data |
| `404 Not Found` | Requested task does not exist |
| `500 Internal Server Error` | Unexpected server error |

## Project Structure

```text
src/main/java/com/prem/taskManagement/
├── controller/
│   └── TaskController.java
├── dto/
│   ├── TaskRequest.java
│   └── TaskResponse.java
├── entity/
│   └── Tasks.java
├── exception/
│   ├── TaskNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repository/
│   └── TaskRepository.java
├── service/
│   ├── TaskService.java
│   └── TaskServiceImpl.java
└── TaskManagementApplication.java
```

## Learning Objectives

This project provides hands-on experience with:

- Designing RESTful APIs
- Implementing layered architecture in Spring Boot
- Dependency injection and service abstraction
- Entity mapping and persistence with JPA
- Using `JpaRepository` and `saveAll()`
- DTOs and separation of API models from database entities
- Request validation and exception handling
- Testing REST endpoints using Postman

## Future Improvements

- Add JUnit and Mockito tests.
- Add pagination and sorting.
- Add task filtering by completion status.
- Introduce Spring Security and JWT authentication.
- Add Docker support for the application and MySQL.
- Use Flyway for database schema migrations.

## License

This project is intended for learning and portfolio development. Add a license if you plan to distribute or reuse the code publicly.
