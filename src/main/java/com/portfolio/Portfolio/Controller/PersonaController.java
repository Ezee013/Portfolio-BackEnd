
package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Interface.IPersonaService;
import com.portfolio.Portfolio.Model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoService;
    
    @GetMapping("traer")
    @ResponseBody
    public List<Persona> getPersona (){
        return persoService.getPersona();
    }
    
    @GetMapping("traer/{id}")
    @ResponseBody
    public Persona findPersona(@PathVariable Long id){
        return persoService.findPersona(id);
    }
    
    
    @PostMapping("crear")
    public String createPersona (@RequestBody Persona per){
        persoService.savePersona(per);
        return "La persona fue creada con exito";
    }
    
    
    @DeleteMapping("borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        persoService.deletePersona(id);
        return "La persona fue borrada con exito";
    }
    
    
    @PutMapping("editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                            @RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam String img){
        
        Persona persona = persoService.findPersona(id);
        
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setImg(img);
        
        persoService.savePersona(persona);
        return persona;
    }
    
}
