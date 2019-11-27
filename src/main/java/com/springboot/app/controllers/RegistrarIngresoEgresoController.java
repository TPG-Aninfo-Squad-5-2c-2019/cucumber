package com.springboot.app.controllers;

import com.springboot.app.models.dao.IngresoEgresoDao;
import com.springboot.app.models.entity.IngresoEgreso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrarIngresoEgresoController {
    @RequestMapping(value="/registrar_ingreso_egreso", method= RequestMethod.GET)
    public String mostrar_form( Model model) {
        model.addAttribute("ingresoegreso", new IngresoEgreso());
        return "registrar_ingreso_egreso";
    }

    @RequestMapping(value="/registrar_ingreso_egreso", method= RequestMethod.POST)
    public String submit_ingreso_egreso(@ModelAttribute IngresoEgreso ingresoegreso) {
        IngresoEgresoDao repo = IngresoEgresoDao.getInstance();
        repo.addIngresoEgreso(ingresoegreso);
        return "resultado_registrar_ingreso_egreso";
    }
}