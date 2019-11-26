package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springboot.app.models.entitys.Cliente;
import com.springboot.app.models.entitys.ItemFactura;
import com.springboot.app.models.entitys.Proyecto;
import com.springboot.app.models.entitys.VersionProducto;

@Controller
public class ClientController {
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public String clients( Model model) {
		
		/*** Tel***/
		List<String> telefonos_PepsiCo = new ArrayList<>();
		List<String> telefonos_Coca_Cola = new ArrayList<>();
		List<String> telefonos_La_Serenisima = new ArrayList<>();
		List<String> telefonos_Jane =  new ArrayList<>();
		
		telefonos_PepsiCo.add("011-5533-5000");
		telefonos_PepsiCo.add("011-4345-5435");
		telefonos_Coca_Cola.add("011-4630-8999");
		telefonos_La_Serenisima.add("011-4645-5055");
		telefonos_Jane.add("1123335465");
		
		/*** Clientes***/
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente pepsiCo = new Cliente(50123151,"PepsiCO","PepsiCo-SRL","Cazadores-2860- Munro",
									telefonos_PepsiCo);
		Cliente CocaCola = new Cliente(5131231,"Coca-Cola", "Coca-Cola-Femsa-de-BA",
										"Av.-Amancio-Alcorta-3570-C1437-CABA",telefonos_Coca_Cola);
		Cliente LaSere = new Cliente(53431121,"La_Serenisima'","Logistica-La-Serenisima" ,
									"Moreno 877 C1091AAQ CABA",telefonos_La_Serenisima);
		Cliente Sara = new Cliente(65431312,"Jane","","Cerrito-2020-CABA",telefonos_Jane);
		
		clientes.add(pepsiCo);
		clientes.add(CocaCola);
		clientes.add(LaSere);
		clientes.add(Sara);
	
		/*** Proyectos ***/
		List<Proyecto> proyectos= new ArrayList<>();
		proyectos.add(new Proyecto("PSA BA 1.1", "Customización", "En proceso"));
		proyectos.add(new Proyecto("PSA CRM 1.0", "Implementación", "En proceso"));
	
		/*** Facturados ***/
		List<ItemFactura> facturados = new ArrayList<>();
		facturados.add(new ItemFactura(true, new VersionProducto("CRM","0.5"), 2));
		facturados.add(new ItemFactura(true, new VersionProducto("CRM","2.1"), 1));
		
		model.addAttribute("titulo", "Datos de clientes");
		model.addAttribute("titulo_proyectos","Proyectos asociados");
		model.addAttribute("titulo_productos","Versiones de productos asociados");
		model.addAttribute("clientes",clientes);
		model.addAttribute("proyectos",proyectos);
		model.addAttribute("facturados",facturados);
		model.addAttribute("page_title", "Clientes");
		
		return "clients";
	}
	
	@GetMapping(value = "/clients/{nombre}")
	public String selectedClient(@PathVariable(value = "nombre") String nombre, Model model) {
		
		/*** Tel***/
		List<String> telefonos_PepsiCo = new ArrayList<>();
		List<String> telefonos_Coca_Cola = new ArrayList<>();
		List<String> telefonos_La_Serenisima = new ArrayList<>();
		List<String> telefonos_Jane =  new ArrayList<>();
		
		telefonos_PepsiCo.add("011-5533-5000");
		telefonos_PepsiCo.add("011-4345-5435");
		telefonos_Coca_Cola.add("011-4630-8999");
		telefonos_La_Serenisima.add("011-4645-5055");
		telefonos_Jane.add("1123335465");
		
		/*** Clientes***/
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente pepsiCo = new Cliente(50123151,"PepsiCO","PepsiCo-SRL","Cazadores-2860- Munro",
									telefonos_PepsiCo);
		Cliente CocaCola = new Cliente(5131231,"Coca-Cola", "Coca-Cola-Femsa-de-BA",
										"Av.-Amancio-Alcorta-3570-C1437-CABA",telefonos_Coca_Cola);
		Cliente LaSere = new Cliente(53431121,"La_Serenisima'","Logistica-La-Serenisima" ,
									"Moreno 877 C1091AAQ CABA",telefonos_La_Serenisima);
		Cliente Sara = new Cliente(65431312,"Jane","","Cerrito-2020-CABA",telefonos_Jane);
		
		clientes.add(pepsiCo);
		clientes.add(CocaCola);
		clientes.add(LaSere);
		clientes.add(Sara);
		
		List<Proyecto> proyectos = new ArrayList<>();
		List<ItemFactura> facturados = new ArrayList<>();
		
		if(nombre.equals("Coca-Cola")) {

			/*** Proyectos ***/
			proyectos.add(new Proyecto("PSA BA 1.1", "Customización", "En proceso"));
			proyectos.add(new Proyecto("PSA CRM 1.0", "Implementación", "En proceso"));
			/*** Facturados ***/
			facturados.add(new ItemFactura(true, new VersionProducto("CRM","0.5"), 2));
			facturados.add(new ItemFactura(true, new VersionProducto("CRM","2.1"), 1));
		}else
			if(nombre.equals("PepsiCO")) {
				/*** Proyectos ***/
				proyectos.add(new Proyecto("PSA New Spring ERP 3.0","Customización","En proceso"));
				proyectos.add(new Proyecto("PSA BA 1.0","Desarrollo","Finalizado"));
				/*** Facturados ***/
				facturados.add(new ItemFactura(true, new VersionProducto("PSA BA","0.5"), 1));
				facturados.add(new ItemFactura(false, new VersionProducto("CRM","2.1"), 5));
			}else
				if(nombre.equals("campaigns")) {
					return "redirect:/campaigns";
				}
		
		model.addAttribute("titulo", "Datos de clientes");
		model.addAttribute("titulo_proyectos","Proyectos asociados");
		model.addAttribute("titulo_productos","Versiones de productos asociados");
		model.addAttribute("clientes",clientes);
		model.addAttribute("proyectos",proyectos);
		model.addAttribute("facturados",facturados);
		model.addAttribute("page_title", "Clientes");
		
		
		return "clients";
	}
}
