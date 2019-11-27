package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IngresoEgresoDao;

@Controller
public class DetalleDiarioIngresosEgresosController {
    @RequestMapping(value="/detalle_diario_ingresos_egresos", method= RequestMethod.GET)
    public String detalle_diario_ingresos_egresos( Model model) {
        IngresoEgresoDao repo = IngresoEgresoDao.getInstance();
        model.addAttribute("ingresos_egresos", repo.getAll());
        return "detalle_diario_ingresos_egresos";
    }
}