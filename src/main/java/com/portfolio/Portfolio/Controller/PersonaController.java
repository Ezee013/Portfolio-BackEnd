
package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.DtoPersona;
import com.portfolio.Portfolio.Interface.IPersonaService;
import com.portfolio.Portfolio.Model.Persona;
import com.portfolio.Portfolio.Model.Skill;
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
@RequestMapping("/persona/")
@CrossOrigin(origins ={"https://frontendportfolio-e59a6.web.app","http://localhost:4200"})
public class PersonaController {
    
    @Autowired
    IPersonaService persoService;
    
    @GetMapping("list")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = persoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable int id){
        if(!persoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona skill = persoService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!persoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        persoService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopersona){      
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(persoService.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona  = new Persona(dtopersona.getNombre(), dtopersona.getApellido() ,dtopersona.getDescripcion(), dtopersona.getProfesion(), dtopersona.getImg());
        persoService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoPersona dtopersona){
        //Validamos si existe el ID
        if(!persoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(persoService.existsByNombre(dtopersona.getNombre()) && persoService.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = persoService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido((dtopersona.getApellido()));
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setProfesion((dtopersona.getProfesion()));
        persona.setImg((dtopersona.getImg()));
        
        
        persoService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
    
}
