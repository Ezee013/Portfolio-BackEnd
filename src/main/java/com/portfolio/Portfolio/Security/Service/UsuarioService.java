
package com.portfolio.Portfolio.Security.Service;

import com.portfolio.Portfolio.Security.Entity.Usuario;
import com.portfolio.Portfolio.Security.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String emailUsuario){
        return usuarioRepo.existsByEmail(emailUsuario);
    }
    
    public void save(Usuario usuario){
        usuarioRepo.save(usuario);
    }
}
