# TaskFlowManager

TaskFlowManager is a modular, extensible task management system built using Spring Boot, GraphQL, and REST. It supports managing departments, users, projects, and tasks efficiently with robust error handling, validations, and database migrations via Liquibase.

## Features

- 🔧 CRUD operations for:
  - Departments
  - Users
  - Projects
  - Tasks
- 🚀 Dual API support:
  - REST (with unified `RestResponse`)
  - GraphQL (using Spring GraphQL)
- 🧪 Input validation with `jakarta.validation`
- 💥 Centralized error handling (REST + GraphQL)
- 🗄️ JPA + MySQL for data persistence
- 🧬 Database migrations via Liquibase
- 📅 Timezone support (Asia/Dhaka)
- 📂 Clean, modular package structure

## Tech Stack

- Java 17
- Spring Boot 3.5.3
- Spring GraphQL
- Spring Data JPA
- MySQL
- Liquibase
- Lombok

## Getting Started

### Prerequisites

- Java 17
- MySQL
- Gradle

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/mdmosfikurrahman/TaskFlowManager.git
   ```

2. Configure your local database in `application-local.yml`:
   ```yaml
   spring.datasource.url=jdbc:mysql://localhost:3306/task_flow_manager
   spring.datasource.username=root
   spring.datasource.password=root
   ```

3. Run the application:
   ```bash
   ./gradlew bootRun
   ```

4. Access the APIs:
   - REST: `http://localhost:8080/api/v1/...`
   - GraphQL: `http://localhost:8080/api/v1/graphql`

## Directory Structure

- `common`: Shared responses, exceptions, utilities
- `departments`, `projects`, `tasks`, `users`: CRUD + GraphQL + DTOs
- `resources/graphql`: Split schema files for GraphQL
- `resources/db`: Liquibase changelog and SQL files

## API Overview

### REST Endpoints

| Resource    | Method | Endpoint               |
|-------------|--------|------------------------|
| Department  | GET    | /departments           |
|             | POST   | /departments           |
|             | PUT    | /departments/{id}      |
|             | DELETE | /departments/{id}      |
| Project     | GET    | /projects              |
|             | POST   | /projects              |
|             | PUT    | /projects/{id}         |
|             | DELETE | /projects/{id}         |
| Task        | GET    | /tasks                 |
|             | POST   | /tasks                 |
|             | PUT    | /tasks/{id}            |
|             | DELETE | /tasks/{id}            |
| User        | GET    | /users                 |
|             | POST   | /users                 |
|             | PUT    | /users/{id}            |
|             | DELETE | /users/{id}            |

### GraphQL

- Query & Mutations for all entities
- Schema split by domain

## License

This project is licensed under the MIT License.
