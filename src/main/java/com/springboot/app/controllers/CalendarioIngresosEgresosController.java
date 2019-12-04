package com.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IngresoEgresoDao;
import com.springboot.app.models.entity.IngresoEgreso;

@Controller
public class CalendarioIngresosEgresosController {
	IngresoEgresoDao repo = IngresoEgresoDao.getInstance();
	
	public void addToModel(Model model) {
	   model.addAttribute("ingresos_egresos", repo.getAll());
	   model.addAttribute("pontos", repo.getAll());
	   model.addAttribute("ingresoegreso", new IngresoEgreso());
	}
	
	@RequestMapping(value="/calendario_ingresos_egresos", method = RequestMethod.GET)
    public String calendario_ingresos_egresos(Model model) {
		addToModel(model);
        return "calendario_ingresos_egresos";
    }
	
	@RequestMapping(value="/registrarIngresoEgreso", method= RequestMethod.GET)
    public String mostrar_form( Model model) {
		addToModel(model);
        return "redirect:/calendario_ingresos_egresos";
    }
	
	@RequestMapping(value="/registrarIngresoEgreso", method= RequestMethod.POST)
    public String mostrar_form( Model model, @ModelAttribute IngresoEgreso ingresoegreso) {
		repo.addIngresoEgreso(ingresoegreso);
		addToModel(model);
        return "redirect:/calendario_ingresos_egresos";
    }
	
	
}
