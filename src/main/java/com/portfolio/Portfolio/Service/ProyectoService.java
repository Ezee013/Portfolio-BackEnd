package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Interface.IProyectoService;
import com.portfolio.Portfolio.Model.Proyecto;
import com.portfolio.Portfolio.Repository.ProyectoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    ProyectoRepository proyectoRepo;
    
    @Override
    public List<Proyecto> list(){
        return proyectoRepo.findAll();
    }
    
    @Override
    public Optional<Proyecto> getOne(int id){
        return proyectoRepo.findById(id);
    }
    
    @Override
    public Optional<Proyecto> getByTitulo(String titulo){
        return proyectoRepo.findByTitulo(titulo);
    }
    
    @Override
    public void save(Proyecto proyecto){
        proyectoRepo.save(proyecto);
    }
    
    @Override
    public void delete(int id){
        proyectoRepo.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return proyectoRepo.existsById(id);
    }
    
    @Override
    public boolean existsByTitulo(String nombre){
        return proyectoRepo.existsByTitulo(nombre);
    }
}

