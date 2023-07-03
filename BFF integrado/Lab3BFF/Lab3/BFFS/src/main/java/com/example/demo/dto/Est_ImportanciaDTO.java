package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Est_ImportanciaDTO {
    
    private int id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    @NotNull
    private Date fecha_registro;

    public Est_ImportanciaDTO(@JsonProperty("id") int id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("alias") String apellido,
            @JsonProperty("fecha_registro") Date fecha_registro) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.alias = apellido;
        this.fecha_registro = fecha_registro;
    }
}