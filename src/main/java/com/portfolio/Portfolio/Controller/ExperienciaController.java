package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.DtoExperiencia;
import com.portfolio.Portfolio.Model.Experiencia;
import com.portfolio.Portfolio.Security.Controller.Mensaje;
import com.portfolio.Portfolio.Service.ExperienciaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia/")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    ExperienciaService xpRepo;
    
    @GetMapping("lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = xpRepo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable int id){
        if(!xpRepo.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = xpRepo.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoXP) {
        if (StringUtils.isBlank(dtoXP.getNombreXP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (xpRepo.existsByNombreXP(dtoXP.getNombreXP())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoXP.getNombreXP(), dtoXP.getDescripcionXP());
        xpRepo.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!xpRepo.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(xpRepo.existsByNombreXP(dtoexp.getNombreXP()) && xpRepo.getByNombreXP(dtoexp.getNombreXP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreXP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = xpRepo.getOne(id).get();
        experiencia.setNombreXP(dtoexp.getNombreXP());
        experiencia.setDescripcionXP((dtoexp.getDescripcionXP()));
        
        xpRepo.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!xpRepo.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        xpRepo.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
