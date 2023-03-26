package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {
    @NotBlank
    private String institucion;
    
    @NotBlank
    private int inicio;
    
    @NotBlank
    private int fin;
    
    @NotBlank
    private String descripcion;
    
    private String img;

    public DtoEducacion() {
    }

    public DtoEducacion(String institucion, int inicio, int fin, String descripcion, String img) {
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.img = img;
    }

}