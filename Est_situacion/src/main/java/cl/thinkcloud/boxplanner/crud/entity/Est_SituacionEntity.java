package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "est_situacion")
public class Est_SituacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "est_submodelo_id")
    private int estSubmodeloId;

    @Column(name = "bsc_objetivo_id")
    private int bscObjetivoId;

    @Column(name = "est_impacto_id")
    private int estImpactoId;

    @Column(name = "est_importancia_id")
    private int estImportanciaId;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "alias")
    private String alias;

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "orden")
    private int orden;

    @Column(name = "incluir")
    private boolean incluir;

    @Column(name = "fecha_registro")
    private String fechaRegistro;

    public Est_SituacionEntity(@JsonProperty("id") int id,
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

