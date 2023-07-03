package cl.thinkcloud.boxplanner.crud.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class est_impactoDTO {
    private int id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    private Date fechaRegistro;

    public est_impactoDTO(@JsonProperty("id") int id,
                          @JsonProperty("nombre") String nombre,
                          @JsonProperty("alias") String alias,
                          @JsonProperty("fecha_registro") Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.fechaRegistro = fechaRegistro;
    }
}
