
package com.portfolio.Portfolio.Controller;


import com.portfolio.Portfolio.Dto.DtoEducacion;
import com.portfolio.Portfolio.Interface.IEducacionService;
import com.portfolio.Portfolio.Model.Educacion;
import com.portfolio.Portfolio.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/educacion/")
@CrossOrigin(origins ={"https://frontendportfolio-e59a6.web.app","http://localhost:4200"})
public class EducacionController {

    @Autowired
    IEducacionService eduService;
    
    @GetMapping("list")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable int id){
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu){      
        if(StringUtils.isBlank(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(eduService.existsByInstitucion(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoedu.getInstitucion(), dtoedu.getInicio(), dtoedu.getFin(), dtoedu.getDescripcion(), dtoedu.getImg());
        eduService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoEducacion dtoedu){
        //Validamos si existe el ID
        if(!eduService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(eduService.existsByInstitucion(dtoedu.getInstitucion()) && eduService.getByInstitucion(dtoedu.getInstitucion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = eduService.getOne(id).get();
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setInicio(dtoedu.getInicio());
        educacion.setFin(dtoedu.getFin());
        educacion.setDescripcion((dtoedu.getDescripcion()));
        educacion.setImg(dtoedu.getImg());
        
        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
}