package com.example.libreriaspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CopiaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;

    private String autore;

    private Integer annoPubblicazione;

    private boolean isDisponibile = true;

    private LocalDateTime dataCreazione;

    public CopiaLibro() {
    }

    public CopiaLibro(Long id, String titolo, String autore, Integer annoPubblicazione, boolean isDisponibile, LocalDateTime dataCreazione) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.isDisponibile = isDisponibile;
        this.dataCreazione = dataCreazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public boolean isDisponibile() {
        return isDisponibile;
    }

    public void setDisponibile(boolean disponibile) {
        isDisponibile = disponibile;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
}
