package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResumenMensualController {
    @RequestMapping(value="/resumen_mensual", method= RequestMethod.GET)
    public String resumen_mensual( Model model) {
        return "resumen_mensual";
    }
}
