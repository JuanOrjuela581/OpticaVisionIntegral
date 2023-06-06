package com.usta.opticavisionintegral.controllers;

import com.usta.opticavisionintegral.Entities.proveedorEntity;
import com.usta.opticavisionintegral.models.services.IproveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class proveedorController {


    @Autowired
    private IproveedorService iproveedorService;

    @GetMapping("listarProveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("titulo", "Listado de Proveedores");
        model.addAttribute("proveedor", iproveedorService.findAll());
        return "listarProveedores";
    }

    @GetMapping("crearProveedor")
    public String crearProveedor(Model model) {
        model.addAttribute("titulo", "Crear Proveedor");
        model.addAttribute("proveedor", new proveedorEntity());
        return "crearProveedor";
    }

    @PostMapping(value = "crearProveedor")
    public String guardarProveedor(@Valid proveedorEntity proveedor, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "error 500";
        }

        proveedor.setEstado(true);
        iproveedorService.save(proveedor);
        status.setComplete();
        return "redirect:/listarProveedores";
    }

    @RequestMapping(value = "/eliminarProveedor/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            iproveedorService.remove(id);
        } else {
            return "404";
        }

        return "redirect:/listarProveedores";
    }

    @RequestMapping(value = "cambiarEstadoProveedor/{id}")
    public String cambiarEstadoProveedor(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            iproveedorService.changeState(id);
        } else {
            return "redirect:/error500";
        }

        return "redirect:/listarProveedores";
    }

    @GetMapping("/editarProveedor/{id}")
    public String mostrarFormularioProveedor(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("proveedoractualizar", iproveedorService.findOne(id));
        return "editarProveedor";
    }

    @PostMapping("/editarProveedor/{id}")
    public String actualizarProveedor(@PathVariable(value = "id") Long id, @ModelAttribute("proveedoractualizar") proveedorEntity proveedor){
        proveedorEntity proveedorExistente = iproveedorService.findOne(id);
        proveedorExistente.setEstado(true);
        proveedorExistente.setNombre_proveedor(proveedor.getNombre_proveedor());
        proveedorExistente.setTelefono_proveedor(proveedor.getTelefono_proveedor());
        proveedorExistente.setCorreo_proveedor(proveedor.getCorreo_proveedor());

        iproveedorService.updateEquipo(proveedorExistente);
        return "redirect:/listarProveedores";
    }
}


