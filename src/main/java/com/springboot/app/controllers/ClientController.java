package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.ClientDao;
import com.springboot.app.models.entitys.Cliente;
import com.springboot.app.models.entitys.ItemFactura;
import com.springboot.app.models.entitys.Proyecto;
import com.springboot.app.models.entitys.VersionProducto;

@Controller
public class ClientController {
	
	private void addToModel(Model model, List<Cliente> clientes, List<Proyecto> proyectos) {
		model.addAttribute("titulo", "Datos de clientes");
		model.addAttribute("titulo_proyectos","Proyectos asociados");
		model.addAttribute("titulo_productos","Versiones de productos asociados");
		model.addAttribute("clientes",clientes);
		model.addAttribute("proyectos",proyectos);
		model.addAttribute("page_title", "Clientes");
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String clients( Model model) {
		
		List<Cliente> clientes = ClientDao.getClients();
		List<Proyecto> proyectos = ClientDao.getProyectos(0);
		
		addToModel(model,clientes,proyectos);
		model.addAttribute("indice",0);
		return "clients";
	}
	
	@GetMapping(value = "/clients/{nombre}")
	public String selectedClient(@PathVariable(value = "nombre") String nombre, Model model) {
		
		List<Proyecto> proyectos = new ArrayList<>();
		List<Cliente> clientes = ClientDao.getClients();
		model.addAttribute("indice",3);
		if(nombre.equals("Coca-Cola")) {
			proyectos = ClientDao.getProyectos(0);
		}else
			if(nombre.equals("PepsiCO")) {
				proyectos = ClientDao.getProyectos(1);
				model.addAttribute("indice",1);
			}else
				if(!nombre.equals("Coca-Cola") &&
				   !nombre.equals("PepsiCO") ) {
					return "redirect:/{nombre}";
				}
		
		addToModel(model,clientes,proyectos);
		
		return "clients";
	}
}
