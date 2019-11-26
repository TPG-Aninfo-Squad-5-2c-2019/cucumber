package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.entitys.IngresoEgreso;

import java.util.List;
import java.util.ArrayList;

@Controller
public class BalanceDetailsController {
    @RequestMapping(value="balance_details", method= RequestMethod.GET)
    public String balanceDetails( Model model) {
        List<IngresoEgreso> lista = new ArrayList<IngresoEgreso>();
        IngresoEgreso a = new IngresoEgreso("Egreso", "Edesur", "Pago de Servicios", "50.000");
        lista.add(a);
        model.addAttribute("ingresos_egresos", lista);
        model.addAttribute("page_title", "BalanceDetails");
        return "balance_details";
    }
}