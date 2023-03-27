package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.DtoSkill;
import com.portfolio.Portfolio.Interface.ISkillService;
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
@CrossOrigin(origins ={"https://frontendportfolio-e59a6.web.app","http://localhost:4200"})
@RequestMapping("/skill/")
public class SkillController {

    @Autowired
    ISkillService skillService;
    
    @GetMapping("list")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        skillService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill){      
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillService.existsByNombre(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoskill.getNombre(), dtoskill.getPorcentaje());
        skillService.save(skill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoSkill dtoskill){
        //Validamos si existe el ID
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(skillService.existsByNombre(dtoskill.getNombre()) && skillService.getByNombre(dtoskill.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillService.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setPorcentaje((dtoskill.getPorcentaje()));
        
        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
}
