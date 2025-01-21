package com.example.inicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inicio.model.TipoDocumento;
import java.util.List;


public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{
    List<TipoDocumento> findByDescripcion(String descripcion);
    List<TipoDocumento> findByDescripcionAndIdNot(String descripcion, int id);
}
