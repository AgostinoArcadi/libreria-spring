package com.example.libreriaspring.controller;

import com.example.libreriaspring.entity.Libro;
import com.example.libreriaspring.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libri")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping
    public ResponseEntity<Libro> addLibro(
            @RequestParam String titolo,
            @RequestParam String autore,
            @RequestParam("anno") Integer annoPubblicazione
    ){
        Libro libroNuovo = libroService.addLibro(titolo, autore, annoPubblicazione);
        return ResponseEntity.ok().body(libroNuovo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findById(@PathVariable Long id) {
        Optional<Libro> libroOpt = libroService.findById(id);

        if(libroOpt.isPresent()) {
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Libro>> findAll() {
        List<Libro> libroList = libroService.elencoLibri();
        return ResponseEntity.ok().body(libroList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroOpt = libroService.updateLibro(id, libro);

        if(libroOpt.isPresent()) {
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libroOpt = libroService.deleteLibro(id);

        if(libroOpt.isPresent()){
            return ResponseEntity.ok().body(libroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}