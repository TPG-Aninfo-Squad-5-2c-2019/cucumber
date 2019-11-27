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
import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.Proyecto;
import com.springboot.app.models.entity.VersionProducto;

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
		
		int indice = 3;
		
		List<Proyecto> proyectos = new ArrayList<>();
		List<Cliente> clientes = ClientDao.getClients();
		
		if(nombre.equals("Coca-Cola")) {
			indice = 0;
			proyectos = ClientDao.getProyectos(indice);
		}else
			if(nombre.equals("PepsiCO")) {
				indice = 1;
				proyectos = ClientDao.getProyectos(indice);
			}else
				if(!nombre.equals("campaigns")) {
					return "redirect:/campaigns";
				}
		
		model.addAttribute("indice", indice);
		
		addToModel(model,clientes,proyectos);
		
		return "clients";
	}
}
