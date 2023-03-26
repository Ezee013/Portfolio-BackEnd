package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.IEducacionService;
import com.portfolio.Portfolio.Model.Educacion;
import com.portfolio.Portfolio.Repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService{
    @Autowired
    EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> list(){
        return eduRepo.findAll();
    }
    
    @Override
    public Optional<Educacion> getOne(int id){
        return eduRepo.findById(id);
    }
    
    @Override
    public Optional<Educacion> getByInstitucion(String institucion){
        return eduRepo.findByInstitucion(institucion);
    }
    
    @Override
    public void save(Educacion edu){
        eduRepo.save(edu);
    }
    
    @Override
    public void delete(int id){
        eduRepo.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return eduRepo.existsById(id);
    }
    
    @Override
    public boolean existsByInstitucion(String institucion){
        return eduRepo.existsByInstitucion(institucion);
    }
   
}