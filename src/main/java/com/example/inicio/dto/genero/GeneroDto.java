package com.example.inicio.dto.genero;

import java.time.LocalDateTime;


public class GeneroDto {
    int id;
    String descripcion;
    int estado;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public GeneroDto(){
        
    }

    public GeneroDto(int id, String descripcion, int estado, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
