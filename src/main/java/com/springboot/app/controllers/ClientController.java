package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.app.models.dao.ClientDao;
import com.springboot.app.models.dao.ClienteDestacadoDao;
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
		model.addAttribute("newClient",new Cliente());
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
	public String selectedClient(@PathVariable(value = "nombre") String nombre,
								 Model model) {
		
		List<Proyecto> proyectos =  new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<ItemFactura> facturados = new ArrayList<>();
	
		Boolean cliente_encontrado = false;
		for (Cliente cliente : cdao.getClients()) {
	
			if(cliente.getNombre().equals(nombre)) {
				cliente_encontrado  = true;
				break;
			}
		}
		
		if(nombre.equals("destacados")) {
			clientes = cddao.getAll();
			if(clientes.isEmpty()) {	
			}else {
				proyectos = ClientDao.getProyectos(clientes.get(0).getNombre());
				facturados = ClientDao.getFacturados(clientes.get(0).getNombre());
				nombre = clientes.get(0).getNombre();
			}
		}else
			if(cliente_encontrado) {
				
				proyectos = ClientDao.getProyectos(nombre);
				clientes = cdao.getClients();
				facturados = ClientDao.getFacturados(nombre);
		}else {
			return "redirect:/{nombre}";
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
	
	@RequestMapping(value = "/alta_cliente", method = RequestMethod.POST)
	public RedirectView crearCliente(HttpServletRequest request, 
			 @RequestParam(value="telefono1") String telefono1,
			 @RequestParam(value="telefono2") String telefono2,
			 @RequestParam(value="telefono3") String telefono3,
			 @ModelAttribute Cliente newClient) {
		
		List<String> tels = new ArrayList<>();
		tels.add(telefono1);
		tels.add(telefono2);
		tels.add(telefono3);
		
		newClient.setTelefonos(tels);
		newClient.setDestacado(false);
		
		ClientDao.getInstance().addClient(newClient);
		
		return new RedirectView("/clients");
	}
	
}
