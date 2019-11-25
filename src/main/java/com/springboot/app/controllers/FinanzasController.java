package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FinanzasController {
    @RequestMapping(value="/finanzas", method= RequestMethod.GET)
    public String finanzas( Model model) {
        return "finanzas";
    }
}