package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BalanceController {
    @RequestMapping(value="/balance", method= RequestMethod.GET)
    public String balance( final Model model) {
        model.addAttribute("page_title", "Ingresos y egresos");
        return "balance";
    }
}
