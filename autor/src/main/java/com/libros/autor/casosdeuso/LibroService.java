package com.libros.autor.casosdeuso;


import org.springframework.stereotype.Service;

import com.libros.autor.dominio.modelo.Libro;
import com.libros.autor.dominio.repositorio.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
