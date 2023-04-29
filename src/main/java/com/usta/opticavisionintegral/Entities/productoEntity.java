package com.usta.opticavisionintegral.entities;

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
        @Column(name = "idproducto")
        private Long idproducto;

        @NotNull
        @Size(min = 1, max = 20)
        @Column(name = "codigo")
        private String codigo;

        @NotNull
        @Size(min = 1, max = 50)
        @Column(name = "nombre")
        private String nombre;

        @NotNull
        @Size(min = 1, max = 100)
        @Column(name = "descripcion")
        private String descripcion;

        @NotNull
        @Column(name = "precio")
        private Float precio;

        @NotNull
        @Column(name = "existencias")
        private Boolean existencias;

        @OneToOne
        @JoinColumn(name = "idproveedor")
        private proveedorEntity idproveedor;

        @NotNull
        @Column(name = "estado")
        private Boolean estado;

        public Long getIdproducto() {
            return idproducto;
        }

        public void setIdproducto(Long idproducto) {
            this.idproducto = idproducto;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Float getPrecio() {
            return precio;
        }

        public void setPrecio(Float precio) {
            this.precio = precio;
        }

        public Boolean getExistencias() {
            return existencias;
        }

        public void setExistencias(Boolean existencias) {
            this.existencias = existencias;
        }

        public proveedorEntity getIdproveedor() {
            return idproveedor;
        }

        public void setIdproveedor(proveedorEntity idproveedor) {
            this.idproveedor = idproveedor;
        }

        public Boolean getEstado() {
            return estado;
        }

        public void setEstado(Boolean estado) {
            this.estado = estado;
        }
    }
