package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ArrayList;

import com.springboot.app.models.entity.IngresoEgreso;

@Controller
public class BalanceDetailsController {
    @RequestMapping(value="balance_details", method= RequestMethod.GET)
    public String balanceDetails( Model model) {
        model.addAttribute("page_title", "Detalles ingresos y egresos");
        List<IngresoEgreso> lista = new ArrayList<IngresoEgreso>();
        IngresoEgreso a = new IngresoEgreso("Egreso", "Edesur", "Pago de Servicios", "50.000");
        lista.add(a);
        model.addAttribute("ingresos_egresos", lista);
        return "balance_details";
    }
}