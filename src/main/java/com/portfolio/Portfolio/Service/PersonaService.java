
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.IPersonaService;
import com.portfolio.Portfolio.Model.Persona;
import com.portfolio.Portfolio.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = persoRepo.findAll();
        return persona;
        
    }
    
    @Override
    public void savePersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = persoRepo.findById(id).orElse(null);
        return persona;
    }

}
