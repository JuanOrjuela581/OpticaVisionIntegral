package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ciudades")
public class ciudadEntity implements Serializable {
    public static final long serialVersionUIO = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id_ciudad;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "nombre_ciudad")
    private String nombre_ciudad;

    public Long getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Long id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
}
