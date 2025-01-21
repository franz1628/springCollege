package com.example.inicio.dto.tipoDocumento;

public class TipoDocumentoCreateDto {
    String descripcion;

    public TipoDocumentoCreateDto(){
        
    }

    public TipoDocumentoCreateDto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
