package com.springboot.app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String clientes(Model model) {
        return "index";
    }
}
