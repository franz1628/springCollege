package com.example.inicio.model;
import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Alumno")
public class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    int id;

    @Column(name = "nombres")
    String nombres;

    @Column(name = "apellido_paterno")
    String apellidoPaterno;

    @Column(name = "apellido_materno")
    String apellidoMaterno;

    @Column(name = "fecha_nacimiento")
    Date fechaNacimiento;

    @Column(name = "numero_documento")
    String numeroDocumento;

    @Column(name = "id_genero")
    int idGenero;

    @Column(name = "id_tipoDocumento")
    int idTipoDocumento;

    @Column(name = "estado", insertable = false)
    int estado;

    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    LocalDateTime created_at;
    
    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false, updatable = false)
    LocalDateTime updated_at;

    public Alumno(){}

    public Alumno(int id, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String numeroDocumento, int idGenero, int idTipoDocumento, int estado, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.idGenero = idGenero;
        this.idTipoDocumento = idTipoDocumento;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
