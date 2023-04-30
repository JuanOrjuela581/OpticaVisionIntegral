package com.usta.opticavisionintegral.controllers;

import com.usta.opticavisionintegral.Entities.opticaEntity;
import com.usta.opticavisionintegral.models.services.IopticaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class opticaController {

    @Autowired
    private IopticaServices iopticaServices;

    @GetMapping("listarOpticas")
    public String listarOpticas(Model model){
        model.addAttribute("titulo","listar Opticas");
        model.addAttribute("opticas",iopticaServices.finAll());
        return "listarOpticas";
    }

    @GetMapping("crearOptica")
    public String crearOptica(Model model){
        model.addAttribute("titulo","Crear Optica");
        model.addAttribute("optica",new opticaEntity());
        return "crearOptica";
    }

    @PostMapping(value = "crearOptica")
    public String guardarOptica(@Valid opticaEntity optica, BindingResult result, SessionStatus status){
        if (result.hasErrors()){
            return "error 500";
        }
        iopticaServices.save(optica);
        status.setComplete();
        return "redirect:/listarOpticas";
    }

    @RequestMapping(value = "/eliminarOptica/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id){
        if (id>0){
            iopticaServices.remove(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarOpticas";
    }

    @GetMapping("/editarOptica/{id}")
    public String mostrarFormularioOptica(@PathVariable(value = "id")Long id, Model model){
        model.addAttribute("titulo","Editar Optica");
        model.addAttribute("actualizarOptica",iopticaServices.findOne(id));
        return "editarOptica";
    }

    @PostMapping("editarOptica/{id}")
    public String actualizarOptica(@PathVariable(value = "id") Long id, @ModelAttribute("actualizarOptica")opticaEntity optica){
        opticaEntity opticaExistente = iopticaServices.findOne(id);
        opticaExistente.setNombre_optica(optica.getNombre_optica());
        opticaExistente.setDireccion_optica(optica.getDireccion_optica());

        iopticaServices.updateOptica(opticaExistente);
        return "redirect:/listarOpticas";
    }
}
