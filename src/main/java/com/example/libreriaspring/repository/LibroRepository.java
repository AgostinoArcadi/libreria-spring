package com.example.libreriaspring.repository;

import com.example.libreriaspring.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
