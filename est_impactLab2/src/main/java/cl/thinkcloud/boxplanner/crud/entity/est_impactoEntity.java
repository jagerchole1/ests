package cl.thinkcloud.boxplanner.crud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "est_impacto")
public class est_impactoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "alias")
    private String alias;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public est_impactoEntity(@JsonProperty("id") int id,
                         @JsonProperty("nombre") String nombre,
                         @JsonProperty("alias") String alias,
                         @JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.fechaRegistro = fechaRegistro;
    }
}

