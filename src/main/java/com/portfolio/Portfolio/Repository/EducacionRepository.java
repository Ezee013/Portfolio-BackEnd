package com.portfolio.Portfolio.Repository;


import com.portfolio.Portfolio.Model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstitucion(String institucion);
    public boolean existsByInstitucion(String institucion);
}
