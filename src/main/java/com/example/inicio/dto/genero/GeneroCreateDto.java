package com.example.inicio.dto.genero;

public class GeneroCreateDto {
    String descripcion;

    public GeneroCreateDto(){
        
    }

    public GeneroCreateDto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
