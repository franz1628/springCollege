package com.example.inicio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inicio.model.Alumno;
import java.util.List;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
    List<Alumno> findBynumeroDocumento(String numeroDocumento);
    List<Alumno> findBynumeroDocumentoAndIdNot(String numeroDocumento, int id);
}
