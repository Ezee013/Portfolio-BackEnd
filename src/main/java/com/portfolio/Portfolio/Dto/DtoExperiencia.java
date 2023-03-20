
package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String nombreXP;
    @NotBlank
    private String descripcionXP;
    

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreXP, String descripcionXP) {
        this.nombreXP = nombreXP;
        this.descripcionXP = descripcionXP;
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
