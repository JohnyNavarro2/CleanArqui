package com.libros.autor.adaptadores.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.libros.autor.dominio.modelo.Autor;
import com.libros.autor.dominio.repositorio.AutorRepository;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Long id, @RequestBody Autor updatedAutor) {
        return autorRepository.findById(id)
                .map(autor -> {
                    autor.setNombre(updatedAutor.getNombre());
                    autor.setBiografia(updatedAutor.getBiografia());
                    return autorRepository.save(autor);
                }).orElseGet(() -> {
                    updatedAutor.setId(id);
                    return autorRepository.save(updatedAutor);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
}
