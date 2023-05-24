package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
public class citaEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id_cita;

    @NotNull
    @Column(name = "fecha_cita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_cita;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "precio_cita")
    private String precio_cita;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "eps_cita")
    private String eps_cita;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "motivo_cita")
    private String motivo_cita;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private pacienteEntity id_paciente;

    @OneToOne
    @JoinColumn(name = "id_doctor")
    private doctorEntity id_doctor;

    public Long getId_cita() {
        return id_cita;
    }

    public void setId_cita(Long id_cita) {
        this.id_cita = id_cita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getPrecio_cita() {
        return precio_cita;
    }

    public void setPrecio_cita(String precio_cita) {
        this.precio_cita = precio_cita;
    }

    public String getEps_cita() {
        return eps_cita;
    }

    public void setEps_cita(String eps_cita) {
        this.eps_cita = eps_cita;
    }

    public String getMotivo_cita() {
        return motivo_cita;
    }

    public void setMotivo_cita(String motivo_cita) {
        this.motivo_cita = motivo_cita;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public pacienteEntity getIdPaciente() {
        return id_paciente;
    }

    public void setIdPaciente(pacienteEntity idPaciente) {
        this.id_paciente = idPaciente;
    }

    public doctorEntity getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(doctorEntity id_doctor) {
        this.id_doctor = id_doctor;
    }
}
