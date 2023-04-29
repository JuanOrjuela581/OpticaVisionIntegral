package com.usta.opticavisionintegral.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "doctores")
public class doctorEntity implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor")
    private Long iddoctor;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "especialidad")
    private String especialidad;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "aniosExp")
    private String aniosExp;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    public Long getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(String aniosExp) {
        this.aniosExp = aniosExp;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

