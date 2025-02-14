package com.libros.autor.dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros.autor.dominio.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
