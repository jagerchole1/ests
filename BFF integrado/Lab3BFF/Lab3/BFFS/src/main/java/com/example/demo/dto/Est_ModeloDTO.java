package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class Est_ModeloDTO {
	
	//@Id
    private int id;

    
    @NotNull
    private int aplica_solo_a_departamentos;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String alias;
    
    @NotBlank
    private String descripcion;
    
    @NotNull
    private int orden;
    
    @NotNull
    private Date fecha_registro;



    public Est_ModeloDTO(@JsonProperty("id") int id, 
    		@JsonProperty("aplica_solo_a_departamentos") int aplica_solo_a_departamentos, 
    		@JsonProperty("nivel") int nivel,
    		@JsonProperty("nombre") String nombre,
    		@JsonProperty("alias") String alias,
    		@JsonProperty("descripcion") String descripcion,
    		@JsonProperty("orden") int orden,
    		@JsonProperty("fecha_registro") Date fecha_registro) {
        super();
        this.id = id;
        this.aplica_solo_a_departamentos = aplica_solo_a_departamentos;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.fecha_registro = fecha_registro;
    }


}