package com.example.inicio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.inicio.dto.genero.GeneroCreateDto;
import com.example.inicio.dto.genero.GeneroDto;
import com.example.inicio.dto.genero.GeneroUpdateDto;
import com.example.inicio.model.Genero;

@Mapper
public interface GeneroMapper{
    GeneroMapper INSTANCE = Mappers.getMapper(GeneroMapper.class);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "estado",ignore = true)
    @Mapping(target = "created_at",ignore = true)
    @Mapping(target = "updated_at",ignore = true)
    Genero toEntity(GeneroCreateDto model);

    @Mapping(target = "created_at",ignore = true)
    @Mapping(target = "updated_at",ignore = true)
    Genero toEntity(GeneroUpdateDto model);
    Genero toEntity(GeneroDto model);

    GeneroDto toDto(Genero model);
}
