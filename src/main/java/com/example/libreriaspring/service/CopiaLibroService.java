package com.example.libreriaspring.service;

import com.example.libreriaspring.entity.CopiaLibro;
import com.example.libreriaspring.entity.Libro;
import com.example.libreriaspring.repository.CopiaLibroRepository;
import com.example.libreriaspring.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CopiaLibroService {

    @Autowired
    private CopiaLibroRepository copiaLibroRepository;

    @Autowired
    LibroRepository libroRepository;

    public Optional<CopiaLibro> aggiungiCopiaLibro(Long libroId) {

        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if(libroOpt.isPresent()) {
            CopiaLibro copiaLibro = new CopiaLibro();
            copiaLibro.setAutore(libroOpt.get().getAutore());
            copiaLibro.setTitolo(libroOpt.get().getTitolo());
            copiaLibro.setAnnoPubblicazione(libroOpt.get().getAnnoPubblicazione());
            copiaLibro.setDataCreazione(LocalDateTime.now());

            CopiaLibro copiaLibroNuovo = copiaLibroRepository.save(copiaLibro);
            return Optional.of(copiaLibroNuovo);
        }
        return Optional.empty();
    }

    public List<CopiaLibro> findAll() {
        return copiaLibroRepository.findAll();
    }

    public Optional<CopiaLibro> findById(Long copiaId) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroRepository.findById(copiaId);

        if(copiaLibroOpt.isPresent()) {
            return copiaLibroOpt;
        }
        return Optional.empty();
    }

    public Optional<CopiaLibro> deleteCopiaLibro(Long copiaId) {
        Optional<CopiaLibro> copiaLibroOpt = copiaLibroRepository.findById(copiaId);

        if(copiaLibroOpt.isPresent()) {
            copiaLibroRepository.deleteById(copiaId);
            return copiaLibroOpt;
        }
        return Optional.empty();
    }

    public Optional<CopiaLibro> prestaCopiaLibro(Long copiaId) {

        Optional<CopiaLibro> copiaLibroOpt = copiaLibroRepository.findById(copiaId);

        if(copiaLibroOpt.isPresent()) {
            copiaLibroOpt.get().setDisponibile(false);

            CopiaLibro copiaLibro = copiaLibroRepository.save(copiaLibroOpt.get());
            return Optional.of(copiaLibro);
        }
        return Optional.empty();
    }

    public Optional<CopiaLibro> restituisciCopiaLibro(Long copiaId) {

        Optional<CopiaLibro> copiaLibroOpt = copiaLibroRepository.findById(copiaId);

        if(copiaLibroOpt.isPresent()) {
            copiaLibroOpt.get().setDisponibile(true);

            CopiaLibro copiaLibro = copiaLibroRepository.save(copiaLibroOpt.get());
            return Optional.of(copiaLibro);
        }
        return Optional.empty();
    }

    public Optional<Long> numeroCopieDisponibili(Long libroId) {
        Optional<Libro> libroOpt = libroRepository.findById(libroId);

        if(libroOpt.isPresent()) {
            String autore = libroOpt.get().getAutore();
            String titolo = libroOpt.get().getTitolo();
            Integer anno = libroOpt.get().getAnnoPubblicazione();
            Long numeroCopie = copiaLibroRepository.countByTitoloAutoreAnno(titolo, autore, anno);

            return Optional.of(numeroCopie);
        }
        return Optional.empty();
    }

}
