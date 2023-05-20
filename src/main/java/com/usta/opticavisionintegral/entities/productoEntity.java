package com.usta.opticavisionintegral.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

    @Entity
    @Table(name = "productos")
    public class productoEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_producto")
        private Long id_producto;

        @NotNull
        @Size(min = 1, max = 20)
        @Column(name = "codigo_producto")
        private String codigo_producto;

        @NotNull
        @Size(min = 1, max = 50)
        @Column(name = "nombre_producto")
        private String nombre_producto;

        @NotNull
        @Size(min = 1, max = 100)
        @Column(name = "descripcion_producto")
        private String descripcion_producto;

        @NotNull
        @Column(name = "precio_producto")
        private Float precio_producto;

        @NotNull
        @Column(name = "existencias_producto")
        private Boolean existencias_producto;

        @OneToOne
        @JoinColumn(name = "idproveedor_producto")
        private proveedorEntity idproveedor_producto;

        @NotNull
        @Column(name = "estado")
        private Boolean estado;

        public Long getId_producto() {
            return id_producto;
        }

        public void setId_producto(Long idproducto) {
            this.id_producto = idproducto;
        }

        public String getCodigo_producto() {
            return codigo_producto;
        }

        public void setCodigo_producto(String codigo) {
            this.codigo_producto = codigo;
        }

        public String getNombre_producto() {
            return nombre_producto;
        }

        public void setNombre_producto(String nombre) {
            this.nombre_producto = nombre;
        }

        public String getDescripcion_producto() {
            return descripcion_producto;
        }

        public void setDescripcion_producto(String descripcion) {
            this.descripcion_producto = descripcion;
        }

        public Float getPrecio_producto() {
            return precio_producto;
        }

        public void setPrecio_producto(Float precio) {
            this.precio_producto = precio;
        }

        public Boolean getExistencias_producto() {
            return existencias_producto;
        }

        public void setExistencias_producto(Boolean existencias) {
            this.existencias_producto = existencias;
        }

        public proveedorEntity getIdproveedor_producto() {
            return idproveedor_producto;
        }

        public void setIdproveedor_producto(proveedorEntity idproveedor) {
            this.idproveedor_producto = idproveedor;
        }

        public Boolean getEstado() {
            return estado;
        }

        public void setEstado(Boolean estado) {
            this.estado = estado;
        }
    }
