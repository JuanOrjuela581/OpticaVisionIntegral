package com.usta.opticavisionintegral.controllers;

<<<<<<< Updated upstream
import com.usta.opticavisionintegral.Entities.pacienteEntity;
=======
import com.usta.opticavisionintegral.entities.pacienteEntity;
>>>>>>> Stashed changes
import com.usta.opticavisionintegral.models.services.IciudadService;
import com.usta.opticavisionintegral.models.services.IopticaService;
import com.usta.opticavisionintegral.models.services.IpacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class pacientesControllers {

    @Autowired
    private IpacienteService ipacienteService;

    @Autowired
    private IopticaService iopticaService;

    @Autowired
    private IciudadService iciudadService;


    @GetMapping("listarPacientes")
    public String listarPacientes (Model model){
        model.addAttribute("titulo","Listado de Pacientes");
        model.addAttribute("pacientes", ipacienteService.finAll());
        return "listarPacientes";
    }

    @GetMapping("/crearPaciente")
    public String formularioCrearPaciente(Model model){
        model.addAttribute("paciente", new pacienteEntity());
        model.addAttribute("titulo", "Crear Paciente");
        model.addAttribute("optica", iopticaService.finAll());
        model.addAttribute("ciudad", iciudadService.finAll());
        return "crearPaciente";
    }
    @PostMapping(value = "crearPaciente")
    public String guardarPaciente(@Valid pacienteEntity paciente, BindingResult result, SessionStatus status){
        if (result.hasErrors()){
            return "crearPaciente";
        }
        ipacienteService.save(paciente);
        status.setComplete();
        return "redirect:/listarPacientes";
    }

    @RequestMapping(value = "/eliminarPaciente/{id}")
    public String eliminarByIdPaciente(@PathVariable(value = "id") Long id){
        if (id>0){
            ipacienteService.remove(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarPacientes";

    }

    @RequestMapping(value = "/cambiarEstadoPaciente/{id}")
    public String cambiarEstadoPaciente(@PathVariable(value = "id") Long id){
        if (id>0){
            ipacienteService.changeState(id);
        }else {
            return "redirect:/error500";
        }
        return "redirect:/listarPacientes";
    }
    @GetMapping("/editarPaciente/{id}")
    public String mostrarFormularioPaciente(@PathVariable(value = "id")Long id, Model model){
        model.addAttribute("titulo","Editar Paciente");
        model.addAttribute("pacienteActualizar", ipacienteService.findOne(id));
        model.addAttribute("optica", iopticaService.finAll());
        model.addAttribute("ciudad", iciudadService.finAll());
        return "editarPaciente";
    }
    @PostMapping("editarPaciente/{id}")
    public String actualizarSeccional(@PathVariable(value = "id") Long id, @ModelAttribute("pacienteActualizar") pacienteEntity paciente){
        pacienteEntity pacienteExistente = ipacienteService.findOne(id);
        pacienteExistente.setIdentificacion_paciente(paciente.getIdentificacion_paciente());
        pacienteExistente.setNombres_paciente(paciente.getNombres_paciente());
        pacienteExistente.setApellido_paciente(paciente.getApellido_paciente());
        pacienteExistente.setFechaNacimiento_paciente(paciente.getFechaNacimiento_paciente());
        pacienteExistente.setDireccion_paciente(paciente.getDireccion_paciente());
        pacienteExistente.setCorreo_paciente(paciente.getCorreo_paciente());
        pacienteExistente.setId_optica(paciente.getId_optica());
        pacienteExistente.setId_ciudad(paciente.getId_ciudad());

        ipacienteService.updatePaciente(pacienteExistente);
        return "redirect:/listarPacientes";
    }

}
