# Spring Boot API Backend

A practical guide to building a production-ready REST API backend with Spring Boot. Covers API design, security, data persistence, and testing — based on the [InfoQ Mini-Book: Building an API Backend with Spring Boot](https://www.infoq.com/minibooks/spring-boot-building-api-backend/).

## What It Covers

- **REST API Design** — resource modeling, HTTP semantics, error handling
- **Data Persistence** — JPA/Hibernate with UUID-based entities
- **Security** — Spring Security with OAuth2 and role-based access
- **Error Handling** — centralized exception handling with structured responses
- **Testing** — integration tests, controller tests, API documentation

## Tech Stack

| Component | Technology |
|---|---|
| Framework | Spring Boot 2.1.4 |
| Language | Java 8+ |
| Database | JPA / Hibernate |
| Security | Spring Security + OAuth2 |
| API | REST |
| Build | Maven |
| Testing | Spring Test, REST Assured |

## Project Structure

```
src/main/java/com/example/copsboot/
├── CopsbootApplication.java          # Main entry point
├── infrastructure/
│   ├── security/                     # OAuth2 & security config
│   ├── json/                         # Custom JSON serializers
│   └── mvc/                          # Exception handlers
├── report/                           # Report domain (REST controller, service, repo)
└── user/                             # User domain (REST controller, service, repo)
```

**Key packages:**
- `report` — Report entity with REST controller and service layer
- `user` — User management with authentication support
- `infrastructure.security` — OAuth2 server configuration and security setup
- `infrastructure.mvc` — Global exception handling for REST APIs

## API Endpoints

### Reports
| Method | Path | Description |
|---|---|---|
| `GET` | `/api/reports` | List all reports |
| `POST` | `/api/reports` | Create a report |

### Users
| Method | Path | Description |
|---|---|---|
| `GET` | `/api/users/{id}` | Get user by ID |
| `POST` | `/api/users` | Create user |

## Getting Started

### Prerequisites
- Java 8+
- Maven 3.x

### Run Locally

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

### Run Tests

```bash
./mvnw test
```

### Build

```bash
./mvnw package -DskipTests
```

## Database

Schema is defined in `create.sql`. The application uses UUIDs as primary keys for all entities.

## Based On

[Practical Guide to Building an API Backend with Spring Boot](https://www.infoq.com/minibooks/spring-boot-building-api-backend/) — InfoQ Mini-Book

---

**YRoss** · [LinkedIn](https://www.linkedin.com/in/ythalorossy/) · [GitHub Profile](https://github.com/ythalorossy)