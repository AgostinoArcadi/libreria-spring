package com.example.libreriaspring.service;

import com.example.libreriaspring.entity.CopiaLibro;
import com.example.libreriaspring.entity.Libro;
import com.example.libreriaspring.repository.CopiaLibroRepository;
import com.example.libreriaspring.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    CopiaLibroRepository copiaLibroRepository;

    public Libro addLibro(String titolo, String autore, Integer annoPubblicazione) {

        Libro libroNuovo = new Libro();
        libroNuovo.setTitolo(titolo);
        libroNuovo.setAutore(autore);
        libroNuovo.setAnnoPubblicazione(annoPubblicazione);

        Libro libroSalvato = libroRepository.save(libroNuovo);
        return libroSalvato;
    }

    public Optional<Libro> findById(Long libroId) {
        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if(libroOpt.isPresent()) {
            return libroOpt;
        }
        return Optional.empty();
    }

    public List<Libro> elencoLibri() {
        return libroRepository.findAll();
    }

    public Optional<Libro> updateLibro(Long libroId, Libro libro) {
        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if(libroOpt.isPresent()) {
            libroOpt.get().setTitolo(libro.getTitolo());
            libroOpt.get().setAutore(libro.getAutore());

            Libro libroUpdated = libroRepository.save(libroOpt.get());
            return Optional.of(libroUpdated);
        }
        return Optional.empty();
    }

    public Optional<Libro> deleteLibro(Long libroId) {
        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if(libroOpt.isPresent()) {
            libroRepository.deleteById(libroId);
            return libroOpt;
        }
        return Optional.empty();
    }

}
