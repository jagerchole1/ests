package cl.thinkcloud.boxplanner.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class Est_SituacionDTO {
    private int id;

    private int estSubmodeloId;

    private int bscObjetivoId;

    private int estImpactoId;

    private int estImportanciaId;

    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;

    @NotBlank
    private String descripcion;

    private int orden;

    private boolean incluir;

    private String fechaRegistro;

    public Est_SituacionDTO(@JsonProperty("id") int id,
                      @JsonProperty("est_submodelo_id") int estSubmodeloId,
                      @JsonProperty("bsc_objetivo_id") int bscObjetivoId,
                      @JsonProperty("est_impacto_id") int estImpactoId,
                      @JsonProperty("est_importancia_id") int estImportanciaId,
                      @JsonProperty("nombre") @NotBlank String nombre,
                      @JsonProperty("alias") @NotBlank String alias,
                      @JsonProperty("descripcion") @NotBlank String descripcion,
                      @JsonProperty("orden") int orden,
                      @JsonProperty("incluir") boolean incluir,
                      @JsonProperty("fecha_registro") String fechaRegistro) {
        this.id = id;
        this.estSubmodeloId = estSubmodeloId;
        this.bscObjetivoId = bscObjetivoId;
        this.estImpactoId = estImpactoId;
        this.estImportanciaId = estImportanciaId;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.incluir = incluir;
        this.fechaRegistro = fechaRegistro;
    }
}

