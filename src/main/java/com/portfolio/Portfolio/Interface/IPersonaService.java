
package com.portfolio.Portfolio.Interface;

import com.portfolio.Portfolio.Model.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
    
    public List<Persona> list();
    
    public Optional<Persona> getOne(int id);
    
    public Optional<Persona> getByNombre(String nombre);
    
    public void save(Persona educacion);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombre(String nombre);
}
