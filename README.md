# Library Management System - REST API with Spring Boot, MySQL, and Hibernate

## Project Overview

This project is about building a RESTful API for managing a library system. Users can add, retrieve, update, and delete books in the system. The application uses Spring Boot to create the REST APIs, MySQL to store data, and Hibernate for object-relational mapping.

---

## What We Did Step by Step

### Step 1: Set Up the Project

- Created a Spring Boot project with dependencies: Spring Web, Spring Data JPA, and MySQL Driver.  
- Imported the project into an IDE like IntelliJ or Eclipse.  
- Configured connection settings in `application.properties` to connect to a MySQL database.

### Step 2: Configure MySQL Database

- Installed and configured MySQL database locally.  
- Created a database named `library_management`.  
- Updated the Spring Boot configuration to connect to this database.

### Step 3: Define the Data Model

- Created a `Book` Java class to represent books with fields:  
  - `id` (unique identifier)  
  - `title`  
  - `author`  
  - `isbn`  
  - `publishedDate`  
- Used Hibernate and JPA annotations to map this class to the `books` table in MySQL.

### Step 4: Create the Repository

- Defined a `BookRepository` interface extending Spring Data JPA’s `JpaRepository`.  
- This repository provides built-in CRUD operations for the `Book` entity.

### Step 5: Build the REST API

- Created a `BookController` class with REST endpoints:  
  - `GET /books` to get all books  
  - `GET /books/{id}` to get a specific book by ID  
  - `POST /books` to add a new book  
  - `PUT /books/{id}` to update book details  
  - `DELETE /books/{id}` to delete a book  
- Implemented the logic to handle each HTTP request and respond accordingly.

### Step 6: Validate and Test the API

- Added basic validation to ensure book data is correct before saving or updating.  
- Implemented exception handling for cases like book not found or invalid input.  
- Tested all endpoints using Postman to confirm correct behavior.  
- Verified data persistence in MySQL database.

---

## How to Run This Project

1. Clone the repository.  
2. Make sure MySQL is installed and running on your machine.  
3. Create the `library_management` database.  
4. Update your `application.properties` with your MySQL username and password.  
5. Open the project in your IDE and run the application.  
6. Use Postman or similar tools to test the API endpoints:  
   - `GET /books`  
   - `GET /books/{id}`  
   - `POST /books`  
   - `PUT /books/{id}`  
   - `DELETE /books/{id}`

---

## Summary

This project provides a practical example of building a full CRUD RESTful API with Spring Boot, connected to a MySQL database using Hibernate for ORM. It demonstrates how to map Java classes to database tables, perform CRUD operations, and test the APIs effectively. This setup is a strong foundation for learning how to build and manage backend services in Java.

---

