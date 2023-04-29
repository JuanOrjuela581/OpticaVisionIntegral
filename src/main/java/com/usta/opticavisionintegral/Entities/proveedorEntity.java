package com.usta.opticavisionintegral.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "proveedores")
public class proveedorEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor")
    private Long idproveedor;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo")
    private String correo;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    public Long getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Long idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}


