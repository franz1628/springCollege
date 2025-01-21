package com.example.inicio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.inicio.dto.tipoDocumento.TipoDocumentoCreateDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoUpdateDto;
import com.example.inicio.model.TipoDocumento;

@Mapper
public interface TipoDocumentoMapper{
    TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "estado",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    TipoDocumento toEntity(TipoDocumentoCreateDto model);

    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    TipoDocumento toEntity(TipoDocumentoUpdateDto model);
    TipoDocumento toEntity(TipoDocumentoDto model);

    TipoDocumentoDto toDto(TipoDocumento model);
}
