package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Data JPA proporciona automáticamente métodos CRUD básicos
}

/*
  ✅ ¿Qué hace esto?
  Al extender JpaRepository<Book, Long>, Spring genera automáticamente todos los métodos CRUD, como:

  - findAll() – Obtener todos los libros.
  - findById(Long id) – Obtener un libro por ID.
  - save(Book book) – Crear o actualizar un libro.
  - deleteById(Long id) – Eliminar un libro por ID.
*/