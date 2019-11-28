package com.springboot.app.controllers;

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


@Controller
public class ClientController {
	
	ClienteDestacadoDao cddao = ClienteDestacadoDao.getInstance();
	ClientDao cdao = ClientDao.getInstance();
	
	private void addToModel(Model model, List<Cliente> clientes,List<Proyecto> proyectos, 
			List<ItemFactura> facturados, String s) {
		model.addAttribute("titulo", "Datos de clientes");
		model.addAttribute("titulo_proyectos","Proyectos asociados");
		model.addAttribute("titulo_productos","Versiones de productos asociados");
		model.addAttribute("clientes",clientes);
		model.addAttribute("proyectos",proyectos);
		model.addAttribute("facturados",facturados);
		model.addAttribute("seleccionado",s);
		model.addAttribute("page_title", "Clientes");
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String clients( Model model) {
		
		List<Cliente> clientes = cdao.getClients();
		List<Proyecto> proyectos = ClientDao.getProyectos("Coca-Cola");
		List<ItemFactura> facturados = ClientDao.getFacturados("Coca-Cola");
		
		addToModel(model,clientes,proyectos,facturados, "Coca-Cola");
	
		return "clients";
	}
	
	@GetMapping(value = "/clients/{nombre}")
	public String selectedClient(@PathVariable(value = "nombre") String nombre, Model model) {
		
		List<Proyecto> proyectos = ClientDao.getProyectos(nombre);
		List<Cliente> clientes = cdao.getClients();
		List<ItemFactura> facturados = ClientDao.getFacturados(nombre);
		
		if(!nombre.equals("Coca-Cola") &&
		   !nombre.equals("PepsiCO") &&
		   !nombre.equals("La Serenisima") &&
		   !nombre.equals("Johana Gutierrez") &&
		   !nombre.equals("destacados")) {
			return "redirect:/{nombre}";
		}else
			if(nombre.equals("destacados")) {
				clientes = cddao.getAll();
				if(clientes.isEmpty()) {
					model.addAttribute("sin_destacados_msg",
										"No existen clientes en esta lista aun");
				}else {
					proyectos = ClientDao.getProyectos(clientes.get(0).getNombre());
					facturados = ClientDao.getFacturados(clientes.get(0).getNombre());
					nombre = clientes.get(0).getNombre();
				}
			}
		
		addToModel(model,clientes,proyectos,facturados,nombre);
		
		return "clients";
	}
	
	@GetMapping(value = "/clients/destacar/{cliente}")
	public String destacar(@PathVariable(value = "cliente") String nuevoDestacado, 
							Model model) {
		
		cddao.agregarCliente(nuevoDestacado);
		List<Cliente> nuevosClientes = cddao.getAll();
		List<Proyecto> proyectos = ClientDao.getProyectos(nuevoDestacado);
		List<ItemFactura> facturados = ClientDao.getFacturados(nuevoDestacado);
		addToModel(model,nuevosClientes,proyectos,facturados,nuevoDestacado);
		
		return "redirect:/clients";
	}
	
	@GetMapping(value = "/clients/degradar/{nombre}")
	public String degradar(@PathVariable(value = "nombre") String viejoDestacado, Model model) {
		
		cddao.eliminarCliente(viejoDestacado);
		List<Cliente> nuevosClientes = cddao.getAll();
		List<Proyecto> proyectos = ClientDao.getProyectos(viejoDestacado);
		List<ItemFactura> facturados = ClientDao.getFacturados(viejoDestacado);
		addToModel(model,nuevosClientes,proyectos,facturados,viejoDestacado);
		
		return "redirect:/clients/destacados";
	}
	
}
