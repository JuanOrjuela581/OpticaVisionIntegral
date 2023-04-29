package com.usta.opticavisionintegral.controllers;

import com.usta.opticavisionintegral.entities.doctorEntity;
import com.usta.opticavisionintegral.models.services.IdoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
@Controller
public class doctorController {

    @Autowired
    private IdoctorService idoctorService;

    @GetMapping("listarDoctores")
    public String listarDoctores(Model model) {
        model.addAttribute("titulo", "Listado de Doctores");
        model.addAttribute("doctor", idoctorService.findAll());
        return "listarDoctores";
    }

    @GetMapping("crearDoctor")
    public String crearDoctor(Model model) {
        model.addAttribute("titulo", "Crear Doctor");
        model.addAttribute("doctor", new doctorEntity());
        return "crearEquipo";
    }

    @PostMapping(value = "crearDoctor")
    public String guardarDoctor(@Valid doctorEntity doctor, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "error 500";
        }

        doctor.setEstado(true);
        idoctorService.save(doctor);
        status.setComplete();
        return "redirect:/listarDoctores";
    }

    @RequestMapping(value = "/eliminarDoctor/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            idoctorService.remove(id);
        } else {
            return "error500";
        }

        return "redirect:/listarDoctores";
    }

    @RequestMapping(value = "cambiarEstadoDoctor/{id}")
    public String cambiarEstadoDoctor(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            idoctorService.changeState(id);
        } else {
            return "redirect:/error500";
        }

        return "redirect:/listarDoctores";
    }

    @GetMapping("/editarDoctor/{id}")
    public String mostrarFormularioDoctor(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "Editar Doctor");
        model.addAttribute("doctoractualizar", idoctorService.findOne(id));
        return "editarDoctor";
    }

    @PostMapping("/editarDoctor/{id}")
    public String actualizarDoctor(@PathVariable(value = "id") Long id, @ModelAttribute("doctoractualizar") doctorEntity doctor){
        doctorEntity doctorExistente = idoctorService.findOne(id);
        doctorExistente.setEstado(true);
        doctorExistente.setNombre(doctor.getNombre());
        doctorExistente.setApellido(doctor.getApellido());
        doctorExistente.setEspecialidad(doctor.getEspecialidad());
        doctorExistente.setAniosExp(doctor.getAniosExp());


        idoctorService.updateDoctor(doctorExistente);
        return "redirect:/listarDoctores";
    }
}
