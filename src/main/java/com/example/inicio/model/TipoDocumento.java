package com.example.inicio.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "TipoDocumento")
public class TipoDocumento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    int id;

    @Column(name = "descripcion")
    String descripcion;

    @Column(name = "estado", insertable = false)
    int estado;

    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    LocalDateTime created_at;
    
    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false, updatable = false)
    LocalDateTime updated_at;

    public TipoDocumento(){

    }

    public TipoDocumento(int id, String descripcion, int estado, LocalDateTime created_at, LocalDateTime updated_at){
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
