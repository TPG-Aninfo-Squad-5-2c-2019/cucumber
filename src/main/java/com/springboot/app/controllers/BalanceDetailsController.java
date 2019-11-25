package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BalanceDetailsController {
    @RequestMapping(value="/balance_details", method= RequestMethod.GET)
    public String balanceDetails( Model model) {
        return "balance_details";
    }
}