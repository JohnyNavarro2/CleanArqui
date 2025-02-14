package com.libros.autor.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros.autor.dominio.modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
