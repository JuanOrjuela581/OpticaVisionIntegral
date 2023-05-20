package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "opticas")
public class opticaEntity implements Serializable {

    private static final long serialVersionUIO = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_optica")
    private Long id_optica;

    @NotNull
    @Size(min = 1,max = 25)
    @Column(name = "nombre_optica")
    private String nombre_optica;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "direccion_optica")
    private String direccion_optica;

    @NotNull
    @Column(name = "estado")
    public Boolean estado;

    public Long getId_optica() {
        return id_optica;
    }

    public void setId_optica(Long id_optica) {
        this.id_optica = id_optica;
    }

    public String getNombre_optica() {
        return nombre_optica;
    }

    public void setNombre_optica(String nombre_optica) {
        this.nombre_optica = nombre_optica;
    }

    public String getDireccion_optica() {
        return direccion_optica;
    }

    public void setDireccion_optica(String direccion_optica) {
        this.direccion_optica = direccion_optica;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
