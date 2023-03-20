
package com.portfolio.Portfolio.Service;

import com.portfolio.Portfolio.Model.Experiencia;
import com.portfolio.Portfolio.Repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
     @Autowired
     ExperienciaRepository rExperiencia;
     
     public List<Experiencia> list(){
         return rExperiencia.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return rExperiencia.findById(id);
     }
     
     public Optional<Experiencia> getByNombreXP(String nombre){
         return rExperiencia.findByNombreE(nombre);
     }
     
     public void save(Experiencia exp){
         rExperiencia.save(exp);
     }
     
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
      public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     public boolean existsByNombreXP(String nombre){
         return rExperiencia.existsByNombreE(nombre);
     }
     
}
