package com.portfolio.Portfolio.Repository;

import com.portfolio.Portfolio.Model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository <Proyecto, Integer>{
    public Optional<Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}

