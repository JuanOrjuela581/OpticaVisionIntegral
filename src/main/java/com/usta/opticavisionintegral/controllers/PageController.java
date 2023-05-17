package com.usta.opticavisionintegral.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/AboutUs")
    public String acercade(Model model){
        return "AboutUs";
    }

    @GetMapping("/Index")
    public String index(Model model){
        return "Index";
    }

    @GetMapping("/Opticitas")
    public String opticitas(Model model){
        return "Opticitas";
    }

    @GetMapping("/AtencionUsuario")
    public String atencionUsuario(Model model){
        return "AtencionUsuario";
    }

    @GetMapping("/Sedes")
    public String sedes(Model model){
        return "Sedes";
    }

    @GetMapping("/Servicios")
    public String servicios(Model model){
        return "Servicios";
    }

}
