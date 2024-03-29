package com.portfolio.Portfolio.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoSkill {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoSkill() {
    }

    public DtoSkill(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

}