package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String link;
    
    private String img;

    public DtoProyecto() {
    }

    public DtoProyecto(String titulo, String descripcion, String link, String img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link = link;
        this.img = img;
    }
    
}
