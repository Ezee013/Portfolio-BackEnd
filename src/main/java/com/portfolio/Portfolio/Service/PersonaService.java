
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.IPersonaService;
import com.portfolio.Portfolio.Model.Persona;
import com.portfolio.Portfolio.Repository.PersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> list() {
        return persoRepo.findAll();
    }

    @Override
    public Optional<Persona> getOne(int id) {
        return persoRepo.findById(id);
    }

    @Override
    public Optional<Persona> getByNombre(String nombre) {
        return persoRepo.findByNombre(nombre);
    }

    @Override
    public void save(Persona persona) {
        persoRepo.save(persona);
    }

    @Override
    public void delete(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return persoRepo.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return persoRepo.existsByNombre(nombre);
    }
    
}
