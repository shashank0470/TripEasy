# Cab Booking API

A Spring Boot REST API for cab registration, driver management, and ride booking.

## Tech stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- MySQL
- Spring Mail

## Prerequisites

- JDK 21
- Maven
- MySQL running locally

## Setup

1. **Clone the project**

2. **Create the database**
   ```sql
   CREATE DATABASE cab_booking;
   ```

3. **Configure application properties**
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   Edit `application.properties` with your MySQL username/password and mail settings.

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
   On Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

   The API starts at `http://localhost:8080`.

## API response format

All endpoints return a consistent wrapper:

```json
{
  "success": true,
  "message": "Success",
  "data": { }
}
```

On error:

```json
{
  "success": false,
  "message": "Invalid CustomerID",
  "data": null
}
```

Validation errors return field-level details in `data`:

```json
{
  "success": false,
  "message": "Validation failed",
  "data": {
    "emailId": "Email must be valid"
  }
}
```

## Main endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/customer/add` | Register a customer |
| GET | `/customer/get/customer-id/{id}` | Get customer by ID |
| GET | `/customer/getAllCustomer` | List all customers |
| POST | `/driver/add-driver` | Register a driver |
| POST | `/cab/register-cab/{driverId}` | Register a cab for a driver |
| POST | `/booking/book/customer/{customerId}` | Book a cab |

## Phase 1 improvements (done)

- Global exception handling with `@RestControllerAdvice`
- Request validation with `@Valid` and Jakarta Bean Validation
- Consistent `ApiResponse` wrapper on all endpoints
- DTOs returned everywhere (no raw entities in API responses)
- Configurable mail sender via `app.mail.from`
- Example config file for local setup

## Learning roadmap

- **Phase 2:** Complete booking lifecycle (complete/cancel trip, release cab)
- **Phase 3:** Pagination, search, Swagger docs
- **Phase 4:** Authentication with Spring Security + JWT
