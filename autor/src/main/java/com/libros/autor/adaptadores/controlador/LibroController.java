package com.libros.autor.adaptadores.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.libros.autor.dominio.modelo.Libro;
import com.libros.autor.dominio.repositorio.LibroRepository;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro updatedLibro) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(updatedLibro.getTitulo());
                    libro.setIsbn(updatedLibro.getIsbn());
                    libro.setAutor(updatedLibro.getAutor());
                    return libroRepository.save(libro);
                }).orElseGet(() -> {
                    updatedLibro.setId(id);
                    return libroRepository.save(updatedLibro);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}
