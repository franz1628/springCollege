package com.example.inicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inicio.dto.alumno.AlumnoCreateDto;
import com.example.inicio.dto.alumno.AlumnoDto;
import com.example.inicio.dto.alumno.AlumnoUpdateDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoDto;
import com.example.inicio.mapper.AlumnoMapper;
import com.example.inicio.mapper.TipoDocumentoMapper;
import com.example.inicio.model.Alumno;
import com.example.inicio.model.TipoDocumento;
import com.example.inicio.repository.AlumnoRepository;

@Service
public class AlumnoService {
    private final AlumnoRepository repository;
    private final GeneroService generoService;
    private final TipoDocumentoService tipoDocumentoService;
    private final String NOEXISTE  = "No existe ese Alumno";
    private final String SIEXISTE = "ya existe ese Alumno";

    
    AlumnoService(AlumnoRepository repository, GeneroService generoService, TipoDocumentoService tipoDocumentoService){
        this.repository = repository;
        this.generoService = generoService;
        this.tipoDocumentoService = tipoDocumentoService;
    }

    public List<AlumnoDto> getAll(){
        List<AlumnoDto> models = repository.findAll().stream().map(AlumnoMapper.INSTANCE::toDto).toList();
        return models;
    }

    public Alumno getId(int id){
        Alumno model = repository.findById(id).orElseThrow(()->new RuntimeException(NOEXISTE));
        return model;
    }

    public AlumnoDto getById(int id){
        AlumnoDto model = AlumnoMapper.INSTANCE.toDto(this.getId(id));
        return model;
    }

    public AlumnoDto save(AlumnoCreateDto model){ 
        generoService.getId(model.getIdGenero());
        tipoDocumentoService.getId(model.getIdTipoDocumento());

        List<Alumno> repetidos = repository.findBynumeroDocumento(model.getNumeroDocumento());

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        Alumno newModel = repository.save(AlumnoMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return AlumnoMapper.INSTANCE.toDto(newModel);
    }

    public AlumnoDto update(int id, AlumnoUpdateDto model){
        model.setId(id);

        generoService.getId(model.getIdGenero());
        tipoDocumentoService.getId(model.getIdTipoDocumento());

        List<Alumno> repetidos =  repository.findBynumeroDocumentoAndIdNot(model.getNumeroDocumento(), id);

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        Alumno newModel = repository.save(AlumnoMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return AlumnoMapper.INSTANCE.toDto(newModel);
    }

    public AlumnoDto delete(int id){
        Alumno modelDelete = this.getId(id);
        modelDelete.setEstado(0);
        
        Alumno newModel = repository.save(modelDelete);
        newModel = this.getId(newModel.getId());
        return AlumnoMapper.INSTANCE.toDto(newModel);
    }
}
