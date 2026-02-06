# User Management System – Spring Boot REST API

A professional backend application built with **Spring Boot**, **PostgreSQL**, and **Spring Data JPA**.  
This project demonstrates real-world REST API development with validation, login, layered architecture, and custom repository queries.

---

## 🚀 Key Features

- **User Registration**
- **User Login** (email + password)
- **Find User by Email**
- **Get All Users, Update, Delete**
- **Field Validation** (`@NotBlank`, `@Email`)
- **Layered Architecture** (Controller → Service → Repository)
- **Custom Repository Method**
- **Global Exception Handling**
- **Swagger API Documentation**
- PostgreSQL Database integration

---

## 🛠 Tech Stack

- **Java 24**
- **Spring Boot 4**
- **Spring Data JPA (Hibernate ORM)**
- **PostgreSQL**
- **Swagger/OpenAPI**
- **Postman (for API testing)**

---

## 📂 Project Structure

src/main/java/com/yourpackage
│
├── controller → Handles HTTP requests
├── service → Business logic
├── repository → Database access & custom queries
├── entity → JPA Entities with validation annotations
├── exception → Custom exception handlers
└── config → Swagger / other configs


---

## 🔌 API Endpoints

| Method | Endpoint                     | Description            |
|--------|-----------------------------|------------------------|
| POST   | `/api/users/register`        | Register new user      |
| POST   | `/api/users/login`           | User login             |
| GET    | `/api/users`                 | Get all users          |
| GET    | `/api/users/email/{email}`   | Find user by email     |
| PUT    | `/api/users/{id}`            | Update user            |
| DELETE | `/api/users/{id}`            | Delete user            |

---

## ⚙️ Setup & Run

1. Clone the repository  
2. Create PostgreSQL database  
3. Update **application.properties** with DB credentials  
4. Run the Spring Boot application  
5. Visit **Swagger UI**:  
http://localhost:8080/swagger-ui.html

6. Test APIs with Postman or Swagger

---

## 📌 Highlights

- Clean REST API following **best practices**
- Strong validation and layered design for maintainability
- Real-world backend patterns ready for production

---

## 🧾 License

This project is licensed under the **MIT License** – see the **LICENSE** file for details.
