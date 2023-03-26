package com.portfolio.Portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String institucion;
    
    @NotNull
    private int inicio;
    
    @NotNull
    private int fin;
    
    @NotNull
    private String descripcion;
    
    private String img;

    public Educacion() {
    }

    public Educacion(String institucion, int inicio, int fin, String descripcion, String img) {
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.img = img;
    }

}