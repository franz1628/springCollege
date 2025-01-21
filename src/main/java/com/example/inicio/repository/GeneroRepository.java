package com.example.inicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inicio.model.Genero;
import java.util.List;


public interface GeneroRepository extends JpaRepository<Genero, Integer>{
    List<Genero> findByDescripcion(String descripcion);
    List<Genero> findByDescripcionAndIdNot(String descripcion, int id);
}
