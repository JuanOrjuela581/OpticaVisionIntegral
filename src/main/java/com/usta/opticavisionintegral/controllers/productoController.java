package com.usta.opticavisionintegral.controllers;

import com.usta.opticavisionintegral.Entities.productoEntity;
import com.usta.opticavisionintegral.models.services.IproductoService;
import com.usta.opticavisionintegral.models.services.IproveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class productoController {

        @Autowired
        private IproductoService iproductoService;

        @Autowired
        private IproveedorService iproveedorService;

        @GetMapping("listarProductos")
        public String listarProductos (Model model){
            model.addAttribute("titulo","Listado De Productos");
            model.addAttribute("productos",iproductoService.findAll());
            return "listarProductos";
        }

        @GetMapping("/crearProducto")
        public String formularioCrearProducto(Model model){
            model.addAttribute("producto", new productoEntity());
            model.addAttribute("titulo","Crear Producto");
           // model.addAttribute("opti", IopticaService.selectOneUni());
            return "crearOptica";
        }
        @PostMapping(value = "crearDirector")
        public String guardarProducto(@Valid productoEntity producto, BindingResult result, SessionStatus status){

            if (result.hasErrors()){
                return "crearProducto";
            }
            producto.setEstado(true);
            iproductoService.save(producto);
            status.setComplete();
            return "redirect:/listarProductos";
        }

        @RequestMapping(value = "/eliminarDirector/{id}")
        public String eliminarById(@PathVariable(value = "id") Long id) {

            if (id > 0) {
                iproductoService.remove(id);
            } else {
                return "error500";
            }

            return "redirect:/listarProductos";
        }
        @RequestMapping(value = "/cambiarEstadoProducto/{id}")
        public String cambiarEstadoProducto(@PathVariable("id") Long id){
            if (id > 0) {
                iproductoService.changeState(id);
            } else {
                return "redirect:/error500";
            }

            return "redirect:/listarProductos";
        }

        @GetMapping("/editarProducto/{id}")
        public String mostrarFormularioEditarProducto(@PathVariable(value = "id") Long id, Model model) {
            model.addAttribute("titulo", "Editar Producto");
            model.addAttribute("productoactualizar", iproductoService.findOne(id));
           // model.addAttribute("opt", iproveedorService.selectOneProv());
            return "editarProducto";
        }

        @PostMapping("/editarProducto/{id}")
        public String actualizarProducto(@PathVariable(value = "id") Long id, @ModelAttribute("productoactualizar") productoEntity producto){
            productoEntity productoExistente = iproductoService.findOne(id);
            productoExistente.setEstado(true);
            productoExistente.setCodigo_producto(producto.getCodigo_producto());
            productoExistente.setNombre_producto(producto.getNombre_producto());
            productoExistente.setDescripcion_producto(producto.getDescripcion_producto());
            productoExistente.setPrecio_producto(producto.getPrecio_producto());
            productoExistente.setIdproveedor_producto(producto.getIdproveedor_producto());

            iproductoService.updateProducto(productoExistente);
            return "redirect:/listarProductos";
        }
    }


