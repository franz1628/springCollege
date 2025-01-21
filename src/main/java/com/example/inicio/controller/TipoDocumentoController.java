package com.example.inicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inicio.dto.ApiResponse;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoCreateDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoUpdateDto;
import com.example.inicio.service.TipoDocumentoService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {
    TipoDocumentoService service;
    
    TipoDocumentoController(TipoDocumentoService service){
        this.service = service;
    }

    @GetMapping("/")
    public ApiResponse<List<TipoDocumentoDto>> get() {
        return new ApiResponse<List<TipoDocumentoDto>>(1,"Registros",service.getAll()) ;
    }
    
    @GetMapping("/{id}")
    public ApiResponse<TipoDocumentoDto> getById(@PathVariable int id) {
        return new ApiResponse<TipoDocumentoDto>(1,"Registros",service.getById(id)) ;
    }

    @PostMapping("/")
    public ApiResponse<TipoDocumentoDto> save(@Valid @RequestBody TipoDocumentoCreateDto model) {
        return new ApiResponse<TipoDocumentoDto>(1,"Guardado correctamente",service.save(model));
    }

    @PutMapping("/{id}")
    public ApiResponse<TipoDocumentoDto> update(@PathVariable int id, @RequestBody TipoDocumentoUpdateDto model) {
        return new ApiResponse<TipoDocumentoDto>(1,"Modificado correctamente",service.update(id,model));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<TipoDocumentoDto> delete(@PathVariable int id) {
        return new ApiResponse<TipoDocumentoDto>(1, "Se cambio de estado a INACTIVO", service.delete(id));
    }
    
}
