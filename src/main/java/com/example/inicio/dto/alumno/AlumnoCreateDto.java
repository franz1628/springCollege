package com.example.inicio.dto.alumno;

import java.sql.Date;

public class AlumnoCreateDto {
    String nombres;
    String apellidoPaterno;
    String apellidoMaterno;
    Date fechaNacimiento;
    String numeroDocumento;
    int idGenero;
    int idTipoDocumento;

    public AlumnoCreateDto(){}
    
    public AlumnoCreateDto(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String numeroDocumento, int idGenero, int idTipoDocumento) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.idGenero = idGenero;
        this.idTipoDocumento = idTipoDocumento;
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

    
}
