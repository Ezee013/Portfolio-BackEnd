
package com.portfolio.Portfolio.Interface;

import com.portfolio.Portfolio.Model.Experiencia;
import java.util.List;
import java.util.Optional;


public interface IExperienciaService {
    
    public List<Experiencia> list();
    
    public Optional<Experiencia> getOne(int id);
    
    public Optional<Experiencia> getByNombre(String nombre);
    
    public void save(Experiencia educacion);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombre(String nombre);
}
