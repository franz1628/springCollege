package com.example.inicio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoCreateDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoDto;
import com.example.inicio.dto.tipoDocumento.TipoDocumentoUpdateDto;
import com.example.inicio.mapper.TipoDocumentoMapper;
import com.example.inicio.model.TipoDocumento;
import com.example.inicio.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {
    private final TipoDocumentoRepository repository;
    private final String NOEXISTE  = "No existe ese tipo de documento";
    private final String SIEXISTE = "ya existe ese tipo de documento";
    
    TipoDocumentoService(TipoDocumentoRepository repository){
        this.repository = repository;
    }

    public List<TipoDocumentoDto> getAll(){
        List<TipoDocumentoDto> models = repository.findAll().stream().map(TipoDocumentoMapper.INSTANCE::toDto).toList();
        return models;
    }

    public TipoDocumento getId(int id){
        TipoDocumento model = repository.findById(id).orElseThrow(()->new RuntimeException(NOEXISTE));
        return model;
    }

    public TipoDocumentoDto getById(int id){
        TipoDocumentoDto model = TipoDocumentoMapper.INSTANCE.toDto(this.getId(id));
        return model;
    }

    public TipoDocumentoDto save(TipoDocumentoCreateDto model){ 
        List<TipoDocumento> repetidos = repository.findByDescripcion(model.getDescripcion());

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        TipoDocumento newModel = repository.save(TipoDocumentoMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return TipoDocumentoMapper.INSTANCE.toDto(newModel);
    }

    public TipoDocumentoDto update(int id, TipoDocumentoUpdateDto model){
        model.setId(id);

        List<TipoDocumento> repetidos =  repository.findByDescripcionAndIdNot(model.getDescripcion(), id);

        if(repetidos.size()!=0){
            throw new RuntimeException(SIEXISTE);
        }

        TipoDocumento newModel = repository.save(TipoDocumentoMapper.INSTANCE.toEntity(model));
        newModel = this.getId(newModel.getId());
        return TipoDocumentoMapper.INSTANCE.toDto(newModel);
    }

    public TipoDocumentoDto delete(int id){
        TipoDocumento modelDelete = this.getId(id);
        modelDelete.setEstado(0);
        
        TipoDocumento newModel = repository.save(modelDelete);
        newModel = this.getId(newModel.getId());
        return TipoDocumentoMapper.INSTANCE.toDto(newModel);
    }
}
