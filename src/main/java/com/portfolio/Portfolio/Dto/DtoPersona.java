
package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String profesion;
    
    private String img;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descripcion, String profesion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.profesion = profesion;
        this.img = img;
    }

}
