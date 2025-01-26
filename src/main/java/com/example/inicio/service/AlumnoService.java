package com.example.inicio.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.inicio.dto.alumno.AlumnoCreateDto;
import com.example.inicio.dto.alumno.AlumnoDto;
import com.example.inicio.dto.alumno.AlumnoUpdateDto;
import com.example.inicio.mapper.AlumnoMapper;
import com.example.inicio.model.Alumno;
import com.example.inicio.repository.AlumnoRepository;

@Service
public class AlumnoService {
    private final AlumnoRepository repository;
    private final GeneroService generoService;
    private final TipoDocumentoService tipoDocumentoService;
    private final String NOEXISTE  = "No existe ese Alumno";
    private final String SIEXISTE = "ya existe ese Alumno";

    @Value("${file.upload-dir}")
    private String uploadDir; 

    
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

    public boolean upload(int id, MultipartFile file) throws IOException{
        this.getId(id);
        
        if(file.isEmpty()){
            return false;
        }

  
         String original = file.getOriginalFilename();
         if (original == null || original.isEmpty()) {
             throw new IOException("El archivo no tiene un nombre válido.");
         }
         String extension = "";
 
         int puntoindex = original.lastIndexOf('.');
         if (puntoindex > 0) {
             extension = original.substring(puntoindex); 
         }
 
         String nuevonombre = id + extension;


        File destino = new File(uploadDir, nuevonombre);


        File uploadD = new File(uploadDir);
        if (!uploadD.exists()) {
            boolean created = uploadD.mkdirs();
            if (!created) {
                throw new IOException("No se pudo crear el directorio de subida.");
            }
        }

        file.transferTo(destino);

        return true;

    }

    public AlumnoDto delete(int id){
        Alumno modelDelete = this.getId(id);
        modelDelete.setEstado(0);
        
        Alumno newModel = repository.save(modelDelete);
        newModel = this.getId(newModel.getId());
        return AlumnoMapper.INSTANCE.toDto(newModel);
    }
}
