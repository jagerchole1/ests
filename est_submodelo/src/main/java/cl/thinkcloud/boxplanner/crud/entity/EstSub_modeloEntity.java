package cl.thinkcloud.boxplanner.crud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "est_submodelo")
public class EstSub_modeloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "est_modelo_id")
    @JsonIgnore
    private EstSub_modeloEntity estmodelo;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Size(max = 5)
    @Column(name = "alias")
    private String alias;

    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public EstSub_modeloEntity(int id, EstSub_modeloEntity estmodelo, String nombre, String alias, String descripcion,
            Date fechaRegistro) {
        super();
        this.id = id;
        this.estmodelo = estmodelo;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }


}
