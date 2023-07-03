package cl.thinkcloud.boxplanner.crud.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EstSubmodeloDTO {

    private int id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    @Size(max = 500)
    private String descripcion;

    private Date fechaRegistro;

    private int est_modelo_id;

    private int orden;

    public EstSubmodeloDTO(@JsonProperty("id") int id,
                    @JsonProperty("est_modelo_id") int est_modelo_id,
                    @JsonProperty("nombre") String nombre,
                    @JsonProperty("alias") String alias,
                    @JsonProperty("descripcion") String descripcion,
                    @JsonProperty("fecha_registro") Date fechaRegistro,
                    @JsonProperty("orden") int orden) {
        this.id = id;
        this.est_modelo_id = est_modelo_id;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.orden = orden;
    }
}
