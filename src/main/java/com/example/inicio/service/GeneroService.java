package com.example.inicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inicio.dto.genero.GeneroCreateDto;
import com.example.inicio.dto.genero.GeneroDto;
import com.example.inicio.dto.genero.GeneroUpdateDto;
import com.example.inicio.mapper.GeneroMapper;
import com.example.inicio.model.Genero;
import com.example.inicio.repository.GeneroRepository;

@Service
public class GeneroService {
    private final GeneroRepository repository;
    private final String NOEXISTE  = "No existe ese genero";
    private final String SIEXISTE = "ya existe ese genero";
    
    GeneroService(GeneroRepository repository){
        this.repository = repository;
    }

    public List<GeneroDto> getAll(){
        List<GeneroDto> models = repository.findAll().stream().map(GeneroMapper.INSTANCE::toDto).toList();
        return models;
    }

    public Genero getId(int id){
        Genero model = repository.findById(id).orElseThrow(()->new RuntimeException(NOEXISTE));
        return model;
    }

    public GeneroDto getById(int id){
        GeneroDto model = GeneroMapper.INSTANCE.toDto(this.getId(id));
        return model;
    }

    public GeneroDto save(GeneroCreateDto model){ 
        List<Genero> repetidos = repository.findByDescripcion(model.getDescripcion());

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        Genero newModel = repository.save(GeneroMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return GeneroMapper.INSTANCE.toDto(newModel);
    }

    public GeneroDto update(int id, GeneroUpdateDto model){
        model.setId(id);
        this.getId(id);

        List<Genero> repetidos =  repository.findByDescripcionAndIdNot(model.getDescripcion(), id);

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        Genero newModel = repository.save(GeneroMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return GeneroMapper.INSTANCE.toDto(newModel);
    }

    public GeneroDto delete(int id){
        Genero modelDelete = this.getId(id);
        modelDelete.setEstado(0);
        
        Genero newModel = repository.save(modelDelete);
        newModel = this.getId(newModel.getId());
        return GeneroMapper.INSTANCE.toDto(newModel);
    }
}
