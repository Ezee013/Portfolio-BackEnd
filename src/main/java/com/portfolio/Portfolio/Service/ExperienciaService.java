
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.IExperienciaService;
import com.portfolio.Portfolio.Model.Experiencia;
import com.portfolio.Portfolio.Repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService {
    
     @Autowired
     ExperienciaRepository xpRepo;
     
    @Override
    public List<Experiencia> list(){
        return xpRepo.findAll();
    }
    
    @Override
    public Optional<Experiencia> getOne(int id){
        return xpRepo.findById(id);
    }
    
    @Override
    public Optional<Experiencia> getByNombre(String nombre){
        return xpRepo.findByNombre(nombre);
    }
    
    @Override
    public void save(Experiencia xp){
        xpRepo.save(xp);
    }
    
    @Override
    public void delete(int id){
        xpRepo.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return xpRepo.existsById(id);
    }
    
    @Override
    public boolean existsByNombre(String nombre){
        return xpRepo.existsByNombre(nombre);
    }

}
