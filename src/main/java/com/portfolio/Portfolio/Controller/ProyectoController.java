package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.DtoProyecto;
import com.portfolio.Portfolio.Interface.IProyectoService;
import com.portfolio.Portfolio.Model.Proyecto;
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
@RequestMapping("/proyecto/")
@CrossOrigin(origins ={"https://frontendportfolio-e59a6.web.app","http://localhost:4200"})
public class ProyectoController {
    @Autowired
    IProyectoService proyectoService;
    
    @GetMapping("list")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproyecto){      
        if(StringUtils.isBlank(dtoproyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectoService.existsByTitulo(dtoproyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoproyecto.getTitulo(), dtoproyecto.getDescripcion(), dtoproyecto.getLink(), dtoproyecto.getImg());
        proyectoService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoProyecto dtoproyecto){
        //Validamos si existe el ID
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(proyectoService.existsByTitulo(dtoproyecto.getTitulo()) && proyectoService.getByTitulo(dtoproyecto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproyecto.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setTitulo(dtoproyecto.getTitulo());
        proyecto.setDescripcion((dtoproyecto.getDescripcion()));
        proyecto.setLink((dtoproyecto.getLink()));
        proyecto.setImg((dtoproyecto.getImg()));
        
        
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
    
}
