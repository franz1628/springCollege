package com.example.inicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inicio.dto.ApiResponse;
import com.example.inicio.dto.genero.GeneroCreateDto;
import com.example.inicio.dto.genero.GeneroDto;
import com.example.inicio.dto.genero.GeneroUpdateDto;
import com.example.inicio.service.GeneroService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/genero")
public class GeneroController {
    GeneroService service;
    
    GeneroController(GeneroService service){
        this.service = service;
    }

    @GetMapping("/")
    public ApiResponse<List<GeneroDto>> get() {
        return new ApiResponse<List<GeneroDto>>(1,"Registros",service.getAll());
    }
    
    @GetMapping("/{id}")
    public ApiResponse<GeneroDto> getById(@PathVariable int id) {
        return new ApiResponse<GeneroDto>(1, "Registro", service.getById(id));
    }

    @PostMapping("/")
    public ApiResponse<GeneroDto> save(@Valid @RequestBody GeneroCreateDto model) {
        return new ApiResponse<GeneroDto>(1, "Guardado exitosamente", service.save(model));
    }

    @PutMapping("/{id}")
    public ApiResponse<GeneroDto> update(@PathVariable int id, @RequestBody GeneroUpdateDto model) {
        return new ApiResponse<GeneroDto>(1, "Actualizado correctamente", service.update(id,model));
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse<GeneroDto> delete(@PathVariable int id) {
        return new ApiResponse<GeneroDto>(1, "Se cambio de estado a INACTIVO", service.delete(id));
    }
}
