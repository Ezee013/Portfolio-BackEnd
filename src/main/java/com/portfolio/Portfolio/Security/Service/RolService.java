
package com.portfolio.Portfolio.Security.Service;

import com.portfolio.Portfolio.Security.Entity.Rol;
import com.portfolio.Portfolio.Security.Enums.RolNombre;

import com.portfolio.Portfolio.Security.Repository.RolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService{
    @Autowired
    public RolRepository rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepo.save(rol);
    }
}
