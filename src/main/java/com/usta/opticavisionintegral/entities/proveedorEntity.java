package com.usta.opticavisionintegral.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "proveedores")
public class proveedorEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id_proveedor;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_proveedor")
    private String nombre_proveedor;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono_proveedor")
    private String telefono_proveedor;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo_proveedor")
    private String correo_proveedor;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long idproveedor) {
        this.id_proveedor = idproveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre) {
        this.nombre_proveedor = nombre;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono) {
        this.telefono_proveedor = telefono;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo) {
        this.correo_proveedor = correo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}


