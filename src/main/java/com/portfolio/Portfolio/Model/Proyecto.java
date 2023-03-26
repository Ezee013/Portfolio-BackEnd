package com.portfolio.Portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String titulo;

    @NotNull
    private String descripcion;
    
     @NotNull
    private String link;
    
    private String img;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String link, String img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link = link;
        this.img = img;
    }

}
