package com.example.inicio.dto.genero;

import java.time.LocalDateTime;


public class GeneroDto {
    int id;
    String descripcion;
    int estado;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public GeneroDto(){
        
    }

    public GeneroDto(int id, String descripcion, int estado, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    
}
