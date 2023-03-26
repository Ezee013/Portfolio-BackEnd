package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.ISkillService;
import com.portfolio.Portfolio.Model.Skill;
import com.portfolio.Portfolio.Repository.SkillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillService implements ISkillService{
    @Autowired
    SkillRepository skillRepo;
    
    @Override
    public List<Skill> list(){
        return skillRepo.findAll();
    }
    
    @Override
    public Optional<Skill> getOne(int id){
        return skillRepo.findById(id);
    }
    
    @Override
    public Optional<Skill> getByNombre(String nombre){
        return skillRepo.findByNombre(nombre);
    }
    
    @Override
    public void save(Skill skill){
        skillRepo.save(skill);
    }
    
    @Override
    public void delete(int id){
        skillRepo.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return skillRepo.existsById(id);
    }
    
    @Override
    public boolean existsByNombre(String nombre){
        return skillRepo.existsByNombre(nombre);
    }
}
