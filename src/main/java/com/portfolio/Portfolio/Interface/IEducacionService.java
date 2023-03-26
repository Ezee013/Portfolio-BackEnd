
package com.portfolio.Portfolio.Interface;

import com.portfolio.Portfolio.Model.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    
    public List<Educacion> list();
    
    public Optional<Educacion> getOne(int id);
    
    public Optional<Educacion> getByInstitucion(String institucion);
    
    public void save(Educacion educacion);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByInstitucion(String institucion);
}
