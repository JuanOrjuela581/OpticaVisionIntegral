package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "doctores")
public class doctorEntity implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id_doctor;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_doctor")
    private String nombre_doctor;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido_doctor")
    private String apellido_doctor;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "especialidad_doctor")
    private String especialidad_doctor;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "aniosexperiencia_doctor")
    private String aniosexperiencia_doctor;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @OneToOne(mappedBy = "id_doctor")
    private citaEntity id_cita;

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(String nombre) {
        this.nombre_doctor = nombre;
    }

    public String getApellido_doctor() {
        return apellido_doctor;
    }

    public void setApellido_doctor(String apellido) {
        this.apellido_doctor = apellido;
    }

    public String getEspecialidad_doctor() {
        return especialidad_doctor;
    }

    public void setEspecialidad_doctor(String especialidad) {
        this.especialidad_doctor = especialidad;
    }

    public String getaniosexperiencia_doctor() {
        return aniosexperiencia_doctor;
    }

    public void setaniosexperiencia_doctor(String aniosExp) {
        this.aniosexperiencia_doctor = aniosExp;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getAniosexperiencia_doctor() {
        return aniosexperiencia_doctor;
    }

    public void setAniosexperiencia_doctor(String aniosexperiencia_doctor) {
        this.aniosexperiencia_doctor = aniosexperiencia_doctor;
    }

    public citaEntity getId_cita() {
        return id_cita;
    }

    public void setId_cita(citaEntity id_cita) {
        this.id_cita = id_cita;
    }
}

