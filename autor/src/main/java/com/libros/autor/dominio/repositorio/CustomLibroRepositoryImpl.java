package com.libros.autor.dominio.repositorio;


import org.springframework.stereotype.Repository;

import com.libros.autor.dominio.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomLibroRepositoryImpl implements CustomLibroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void customMethodToUpdateLibro(Libro libro) {
        entityManager.merge(libro);
        entityManager.flush();
    }
}
