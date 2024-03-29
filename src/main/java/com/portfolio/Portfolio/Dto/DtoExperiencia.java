
package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private int inicio;
    
    @NotBlank
    private int fin;
    
    @NotBlank
    private String descripcion;
    
    private String img;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombre, int inicio, int fin, String descripcion, String img) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.img = img;
    }

}
