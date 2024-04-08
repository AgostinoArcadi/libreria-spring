package com.example.libreriaspring.controller;

import com.example.libreriaspring.entity.CopiaLibro;
import com.example.libreriaspring.entity.Libro;
import com.example.libreriaspring.service.CopiaLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/copie")
public class CopiaLibroController {

    @Autowired
    CopiaLibroService copiaLibroService;

    @PostMapping("/{id}")
    public ResponseEntity<CopiaLibro> aggiungiCopiaLibro(@PathVariable Long id) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroService.aggiungiCopiaLibro(id);

        if(copiaLibroOpt.isPresent()) {
            return ResponseEntity.ok().body(copiaLibroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopiaLibro> findById(@PathVariable Long id) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroService.findById(id);

        if(copiaLibroOpt.isPresent()) {
            return ResponseEntity.ok().body(copiaLibroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CopiaLibro>> findAll() {
        List<CopiaLibro> copiaLibroList = copiaLibroService.findAll();
        return ResponseEntity.ok().body(copiaLibroList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CopiaLibro> deleteLibro(@PathVariable Long id) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroService.deleteCopiaLibro(id);

        if(copiaLibroOpt.isPresent()){
            return ResponseEntity.ok().body(copiaLibroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/prestito")
    public ResponseEntity<CopiaLibro> prestaCopiaLibro(@PathVariable Long id) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroService.prestaCopiaLibro(id);

        if(copiaLibroOpt.isPresent()) {
            return ResponseEntity.ok().body(copiaLibroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/restituzione")
    public ResponseEntity<CopiaLibro> restituisciCopiaLibro(@PathVariable Long id) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroService.restituisciCopiaLibro(id);

        if(copiaLibroOpt.isPresent()) {
            return ResponseEntity.ok().body(copiaLibroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/disponibili")
    public ResponseEntity<Long> numeroCopieDisponibili(@PathVariable Long id) {
        Optional<Long> numeroCopieOpt = copiaLibroService.numeroCopieDisponibili(id);

        if(numeroCopieOpt.isPresent()) {
            return ResponseEntity.ok().body(numeroCopieOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

}
