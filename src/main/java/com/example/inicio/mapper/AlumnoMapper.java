package com.example.inicio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.inicio.dto.alumno.AlumnoCreateDto;
import com.example.inicio.dto.alumno.AlumnoDto;
import com.example.inicio.dto.alumno.AlumnoUpdateDto;
import com.example.inicio.model.Alumno;

@Mapper
public interface AlumnoMapper{
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "estado",ignore = true)
    @Mapping(target = "created_at",ignore = true)
    @Mapping(target = "updated_at",ignore = true)
    Alumno toEntity(AlumnoCreateDto model);

    @Mapping(target = "created_at",ignore = true)
    @Mapping(target = "updated_at",ignore = true)
    Alumno toEntity(AlumnoUpdateDto model);
    Alumno toEntity(AlumnoDto model);

    AlumnoDto toDto(Alumno model);
}
