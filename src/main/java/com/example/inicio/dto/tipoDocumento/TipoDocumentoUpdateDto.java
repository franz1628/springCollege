package com.example.inicio.dto.tipoDocumento;

public class TipoDocumentoUpdateDto {
    int id;
    String descripcion;
    int estado;

    public TipoDocumentoUpdateDto(){
        
    }

    public TipoDocumentoUpdateDto(int id, String descripcion, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
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
}
