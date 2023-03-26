package com.portfolio.Portfolio.Interface;

import com.portfolio.Portfolio.Model.Proyecto;
import java.util.List;
import java.util.Optional;


public interface IProyectoService {
    public List<Proyecto> list();
    
    public Optional<Proyecto> getOne(int id);
    
    public Optional<Proyecto> getByTitulo(String titulo);
    
    public void save(Proyecto proyecto);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByTitulo(String titulo);
}
