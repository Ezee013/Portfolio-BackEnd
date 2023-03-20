
package com.portfolio.Portfolio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreXP;
    private String descripcionXP;
    

    public Experiencia() {
    }

    public Experiencia(String nombreXP, String descripcionXP) {
        this.nombreXP = nombreXP;
        this.descripcionXP = descripcionXP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreXP() {
        return nombreXP;
    }

    public void setNombreXP(String nombreXP) {
        this.nombreXP = nombreXP;
    }

    public String getDescripcionXP() {
        return descripcionXP;
    }

    public void setDescripcionXP(String descripcionXP) {
        this.descripcionXP = descripcionXP;
    }
    
    
   
    
}