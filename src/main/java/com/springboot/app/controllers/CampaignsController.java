package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CampaignsController {
    @RequestMapping(value="/campaigns", method=RequestMethod.GET)
    public String campaigns( Model model) {
        model.addAttribute("page_title", "Campañas");
        return "campaigns";
    }
}
