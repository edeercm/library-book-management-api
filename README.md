# Library Management System
### REST API with Spring Boot, MySQL, and Hibernate

RESTful API para gestionar una biblioteca: agregar, consultar, actualizar y eliminar libros. Construida con **Spring Boot**, **Spring Data JPA** (Hibernate) y **MySQL**.

---

## 📌 Project Overview

Este proyecto implementa una **API REST CRUD** para gestionar libros en un sistema de biblioteca. Usa:

- **Spring Boot** para crear los endpoints REST
- **Spring Data JPA** (Hibernate) para mapeo objeto-relacional
- **MySQL** como base de datos persistente

---

## ✨ Funcionalidades

- Crear nuevos libros (`POST`)
- Obtener lista de todos los libros (`GET`)
- Obtener un libro por ID (`GET`)
- Actualizar información de un libro (`PUT`)
- Eliminar un libro (`DELETE`)
- Validación básica de datos
- Manejo de excepciones (libro no encontrado, input inválido)

---

## 🛠 Tecnologías

- Spring Boot 3.x (compatible con Java 17+)
- Java 17+
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL 8.0+
- Maven (wrapper incluido)

---

## 📂 Estructura del proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── library_management/
│   │               ├── LibraryManagementApplication.java
│   │               ├── controller/
│   │               │   └── BookController.java
│   │               ├── entity/
│   │               │   └── Book.java
│   │               └── repository/
│   │                   └── BookRepository.java
│   └── resources/
│       └── application.properties
├── test/
│   └── java/
│       └── com/
│           └── example/
│               └── library_management/
│                   └── LibraryManagementApplicationTests.java
└── pom.xml
```

> ⚠️ Verifica el paquete real en tu repositorio (`com.example.library_management` puede variar).

---

## 🧠 Modelo de datos

### Entidad `Book`

| Campo            | Tipo      | Descripción                     |
|------------------|-----------|---------------------------------|
| `id`             | Long      | Clave primaria autogenerada     |
| `title`          | String    | Título del libro                |
| `author`         | String    | Autor del libro                 |
| `isbn`           | String    | ISBN (único recomendado)        |
| `publishedDate`  | LocalDate | Fecha de publicación            |

**Repositorio:**  
`BookRepository` extiende `JpaRepository<Book, Long>`

**Controlador:**  
`BookController` expone endpoints REST bajo `/books`

---

## ⚙️ Configuración

### Requisitos previos

- **Java 17+** instalado
- **Maven 3.6+** (o usar `mvnw`/`mvnw.cmd`)
- **MySQL 8.0+** instalado y ejecutándose

### Configuración de MySQL

1. Crear la base de datos:

```sql
CREATE DATABASE library_management;
```

2. Actualizar `application.properties` con tus credenciales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=tu_password_aqui
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

> ⚠️ Cambia `root` y `tu_password_aqui` por tus credenciales reales de MySQL.

---

## ▶️ Construir y ejecutar

### Windows

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

### Unix/macOS

```bash
./mvnw clean package
./mvnw spring-boot:run
```

La API estará disponible en: **http://localhost:8080**

---

## 🔌 Endpoints (CRUD)

| Método | Ruta            | Descripción              | Códigos de respuesta        |
|--------|-----------------|--------------------------|-----------------------------|
| GET    | `/books`        | Listar todos los libros  | 200 OK                      |
| GET    | `/books/{id}`   | Obtener libro por ID     | 200 OK, 404 Not Found       |
| POST   | `/books`        | Crear nuevo libro        | 201 Created, 400 Bad Request|
| PUT    | `/books/{id}`   | Actualizar libro         | 200 OK, 404 Not Found       |
| DELETE | `/books/{id}`   | Eliminar libro           | 204 No Content, 404 Not Found|

---

## 🧪 Ejemplos de uso (cURL)

### Obtener todos los libros

```bash
curl -X GET http://localhost:8080/books
```

### Obtener un libro por ID

```bash
curl -X GET http://localhost:8080/books/1
```

### Crear un libro

```bash
curl -X POST http://localhost:8080/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Código Limpio",
    "author": "Robert C. Martin",
    "isbn": "978-0132350884",
    "publishedDate": "2008-08-01"
  }'
```

### Actualizar un libro

```bash
curl -X PUT http://localhost:8080/books/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Código Limpio - Actualizado",
    "author": "Robert C. Martin",
    "isbn": "978-0132350884",
    "publishedDate": "2008-08-01"
  }'
```

### Eliminar un libro

```bash
curl -X DELETE http://localhost:8080/books/1
```

---

## ✅ Validación y pruebas

- Validación básica asegurando que datos de libro sean correctos antes de guardar/actualizar
- Manejo de excepciones para casos como:
  - Libro no encontrado (404)
  - Input inválido (400)
- Pruebas con **Postman** para confirmar comportamiento correcto
- Verificación de persistencia en **MySQL**

---

## 🧩 Buenas prácticas y mejoras recomendadas

- Añadir capa **service** para separar lógica de negocio del controlador
- Usar **DTOs** para evitar exponer la entidad directamente
- Implementar validaciones con `@Valid` y annotations de `jakarta.validation`
- Añadir manejo centralizado de errores con `@ControllerAdvice`
- Implementar tests unitarios e integración:
  - `@SpringBootTest` para pruebas de integración
  - `@DataJpaTest` para pruebas de repositorio
- Documentar API con **OpenAPI/Swagger** para facilitar consumo
- Añadir autenticación/autorización (JWT) si la API será pública
- Configurar **polls de conexión** y pooling (HikariCP) para producción

---

## 📝 Resumen

Este proyecto es un ejemplo práctico de cómo construir una **API REST CRUD completa** con **Spring Boot** conectada a una base de datos **MySQL** usando **Hibernate** para ORM. Demuestra:

- Mapeo de clases Java a tablas de base de datos
- Operaciones CRUD completas
- Validación y manejo de excepciones
- Pruebas de API con Postman/cURL
- Persistencia de datos en MySQL

Es una base sólida para aprender y extender hacia servicios backend más complejos en Java.

---

## 📄 Licencia

Agregar licencia si se requiere (ej. MIT).