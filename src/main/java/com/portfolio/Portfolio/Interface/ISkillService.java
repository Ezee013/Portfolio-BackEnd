
package com.portfolio.Portfolio.Interface;

import com.portfolio.Portfolio.Model.Skill;
import java.util.List;
import java.util.Optional;

public interface ISkillService {
    
    public List<Skill> list();
    
    public Optional<Skill> getOne(int id);
    
    public Optional<Skill> getByNombre(String nombre);
    
    public void save(Skill educacion);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombre(String nombre);
}
