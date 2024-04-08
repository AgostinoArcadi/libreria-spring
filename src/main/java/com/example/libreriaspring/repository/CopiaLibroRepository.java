package com.example.libreriaspring.repository;

import com.example.libreriaspring.entity.CopiaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiaLibroRepository extends JpaRepository<CopiaLibro, Long> {

    @Query("SELECT COUNT(c.id) FROM CopiaLibro c WHERE c.titolo = :titolo AND c.autore = :autore AND annoPubblicazione = :annoPubblicazione")
    Long countByTitoloAutoreAnno(String titolo, String autore, Integer annoPubblicazione);
}
