package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalendarioIngresosEgresosController {
    @RequestMapping(value="/calendario_ingresos_egresos", method= RequestMethod.GET)
    public String calendario_ingresos_egresos( Model model) {
        return "calendario_ingresos_egresos";
    }
}