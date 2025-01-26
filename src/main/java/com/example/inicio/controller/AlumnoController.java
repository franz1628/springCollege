package com.example.inicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.inicio.dto.ApiResponse;
import com.example.inicio.dto.alumno.AlumnoCreateDto;
import com.example.inicio.dto.alumno.AlumnoDto;
import com.example.inicio.dto.alumno.AlumnoUpdateDto;
import com.example.inicio.service.AlumnoService;

import jakarta.validation.Valid;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    AlumnoService service;
    
    AlumnoController(AlumnoService service){
        this.service = service;
    }

    @GetMapping("/")
    public ApiResponse<List<AlumnoDto>> get() {
        return new ApiResponse<List<AlumnoDto>>(1,"Registros", service.getAll());
    }
    
    @GetMapping("/{id}")
    public ApiResponse<AlumnoDto> getById(@PathVariable int id) {
        return new ApiResponse<AlumnoDto>(1, "Regustri", service.getById(id)) ;
    }

    @PostMapping("/")
    public ApiResponse<AlumnoDto> save(@Valid @RequestBody AlumnoCreateDto model) {
        return new ApiResponse<AlumnoDto>(1, "Guardado correctamente", service.save(model));
    }

    @PutMapping("/{id}")
    public ApiResponse<AlumnoDto> update(@PathVariable int id, @RequestBody AlumnoUpdateDto model) {
        return new ApiResponse<AlumnoDto>(1, "Modificado correctamente", service.update(id,model));
    }

    @PostMapping("/upload/{id}")
    public boolean upload(@PathVariable int id,@RequestBody MultipartFile file) throws IOException{
        return service.upload(id,file);
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse<AlumnoDto> delete(@PathVariable int id) {
        return new ApiResponse<AlumnoDto>(1, "Se cambio de estado a INACTIVO", service.delete(id));
    }
}
