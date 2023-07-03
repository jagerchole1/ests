package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "est_importancia")
public class Est_ImportanciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "alias")
    private String alias;

    @NotNull
    @Column(name = "fecha_registro")
    private Date fecha_registro;

    public Est_ImportanciaEntity(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre,
            @JsonProperty("alias") String alias, @JsonProperty("fecha_registro") Date fecha_registro) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.fecha_registro = fecha_registro;

    }

}
