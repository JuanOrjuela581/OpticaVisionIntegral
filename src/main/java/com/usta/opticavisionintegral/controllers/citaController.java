package com.usta.opticavisionintegral.controllers;

import com.usta.opticavisionintegral.Entities.citaEntity;
import com.usta.opticavisionintegral.models.services.IcitaService;
import com.usta.opticavisionintegral.models.services.IdoctorService;
import com.usta.opticavisionintegral.models.services.IpacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class citaController {

    @Autowired
    private IcitaService icitaService;

    @Autowired
    private IpacienteService ipacienteService;

    @Autowired
    private IdoctorService idoctorService;

    @GetMapping("listarCitas")
    public String listarCitas (Model model){
        model.addAttribute("titulo","Listado De Citas");
        model.addAttribute("citas",icitaService.findAll());
        return "listarCitas";
    }

    @GetMapping("/crearCita")
    public String formularioCrearCita(Model model){
        model.addAttribute("cita", new citaEntity());
        model.addAttribute("titulo","Crear Cita");
        model.addAttribute("pac", ipacienteService.selectOnePac());
        model.addAttribute("doc", idoctorService.selectOneDoc());
        return "crearCita";
    }
    @PostMapping(value = "crearCita")
    public String guardarCita(@Valid citaEntity cita, BindingResult result, SessionStatus status){

        if (result.hasErrors()){
            return "crearCita";
        }
        cita.setEstado(true);
        icitaService.save(cita);
        status.setComplete();
        return "redirect:/listarCitas";
    }

    @RequestMapping(value = "/eliminarCita/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {

        if (id > 0) {
            icitaService.remove(id);
        } else {
            return "404";
        }

        return "redirect:/listarCitas";
    }
    @RequestMapping(value = "/cambiarEstadoCita/{id}")
    public String cambiarEstadoCita(@PathVariable("id") Long id){
        if (id > 0) {
            icitaService.changeState(id);
        } else {
            return "redirect:/error500";
        }

        return "redirect:/listarCitas";
    }

    @GetMapping("/editarCita/{id}")
    public String mostrarFormularioEditarCita(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "Editar Cita");
        model.addAttribute("citaactualizar", icitaService.findOne(id));
        model.addAttribute("pac", ipacienteService.selectOnePac());
        model.addAttribute("doc", idoctorService.selectOneDoc());
        return "editarCita";
    }

    @PostMapping("/editarCita/{id}")
    public String actualizarCita(@PathVariable(value = "id") Long id, @ModelAttribute("citaactualizar") citaEntity cita){
        citaEntity citaExistente = icitaService.findOne(id);
        citaExistente.setEstado(true);
        citaExistente.setFecha_cita(cita.getFecha_cita());
        citaExistente.setPrecio_cita(cita.getPrecio_cita());
        citaExistente.setEps_cita(cita.getEps_cita());
        citaExistente.setMotivo_cita(cita.getMotivo_cita());
        citaExistente.setId_paciente(cita.getId_paciente());
        citaExistente.setId_doctor(cita.getId_doctor());

        icitaService.updateCita(citaExistente);
        return "redirect:/listarCitas";
    }
}
