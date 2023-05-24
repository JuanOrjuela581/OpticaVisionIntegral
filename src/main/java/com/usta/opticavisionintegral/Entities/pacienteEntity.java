package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class pacienteEntity implements Serializable {

    private static final long serialVersionUIO = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id_paciente;

    @NotNull
    @Size(min = 1,max = 25)
    @Column(name = "identificacion_paciente")
    private String identificacion_paciente;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "nombres_paciente")
    private String nombres_paciente;

    @NotNull
    @Size(min = 1,max = 25)
    @Column(name = "apellido_paciente")
    private String apellido_paciente;

    @NotNull
    @Column(name = "fechanacimiento_paciente")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento_paciente;

    @NotNull
    @Size(min = 1,max = 100)
    @Column(name = "direccion_paciente")
    private String direccion_paciente;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "correo_paciente")
    private String correo_paciente;

    @NotNull
    @Column(name = "estado")
    public Boolean estado;

    @JoinColumn(name = "id_optica", referencedColumnName = "id_optica")
    @ManyToOne(fetch = FetchType.LAZY)
    private opticaEntity id_optica;

    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(fetch = FetchType.LAZY)
    private ciudadEntity id_ciudad;





    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getIdentificacion_paciente() {
        return identificacion_paciente;
    }

    public void setIdentificacion_paciente(String identificacion_paciente) {
        this.identificacion_paciente = identificacion_paciente;
    }

    public String getNombres_paciente() {
        return nombres_paciente;
    }

    public void setNombres_paciente(String nombres_paciente) {
        this.nombres_paciente = nombres_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public Date getFechaNacimiento_paciente() {
        return fechanacimiento_paciente;
    }

    public void setFechaNacimiento_paciente(Date fechaNacimiento_paciente) {
        this.fechanacimiento_paciente = fechaNacimiento_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public opticaEntity getId_optica() {
        return id_optica;
    }

    public void setId_optica(opticaEntity id_optica) {
        this.id_optica = id_optica;
    }

    public ciudadEntity getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(ciudadEntity id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
