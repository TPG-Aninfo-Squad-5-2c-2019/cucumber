package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.Proyecto;
import com.springboot.app.models.entity.VersionProducto;

public class ClientDao {
	
	private static ClientDao cdao = null;
	
	private static List<Cliente> clientes =  new ArrayList<>();	
	
	public static ClientDao getInstance() {
		if(cdao == null) {
			cdao = new ClientDao();
			
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
			
			/*** Clientes ***/
			
			Cliente pepsiCo = new Cliente(50123151,"PepsiCO","PepsiCo-SRL","Cazadores-2860- Munro",
										telefonos_PepsiCo);
			Cliente CocaCola = new Cliente(5131231,"Coca-Cola", "Coca-Cola-Femsa-de-BA",
											"Av.-Amancio-Alcorta-3570-C1437-CABA",telefonos_Coca_Cola);
			Cliente LaSerenisima = new Cliente(53431121,"La Serenisima","Logistica-La-Serenisima" ,
					"Moreno 877 C1091AAQ CABA",telefonos_La_Serenisima);
			Cliente Johana = new Cliente(65431312,"Johana Gutierrez","","Cerrito-2020-CABA",telefonos_Jane);
			
			pepsiCo.setDestacado(false);
			CocaCola.setDestacado(false);
			LaSerenisima.setDestacado(false);
			Johana.setDestacado(false);
			
			clientes.add(pepsiCo);
			clientes.add(CocaCola);
			clientes.add(LaSerenisima);
			clientes.add(Johana);
			
		}
		
		return cdao;
	}
	
	private static Map<String,List<Proyecto>> getProjectMap(){
		Map <String, List<Proyecto>> mapaDeProyectos =  new HashMap<>();
		Proyecto p1 = new Proyecto("PSA BA 1.1", "Customización", "En proceso");
		Proyecto p2 = new Proyecto("PSA CRM 1.0", "Implementación", "En proceso");
		Proyecto p3 = new Proyecto("PSA New Spring ERP 3.0","Customización","En proceso");
		Proyecto p4 = new Proyecto("PSA BA 1.0","Desarrollo","Finalizado");
		Proyecto p5 = new Proyecto("PSA ERP 3.4", "Desarrollo", "En proceso");
		Proyecto p6 = new Proyecto("PSA CRM 2.0", "Customización", "Finalizado");
		
		List<Proyecto> lp = new ArrayList<>();
		lp.add(p1);
		lp.add(p2);
		mapaDeProyectos.put("Coca-Cola", lp);
		lp = new ArrayList<>();
		lp.add(p3);
		lp.add(p5);
		lp.add(p6);
		mapaDeProyectos.put("PepsiCO", lp);
		lp = new ArrayList<>();
		lp.add(p1);
		lp.add(p4);
		lp.add(p6);
		mapaDeProyectos.put("La Serenisima", lp);
		lp = new ArrayList<>();
		lp.add(p3);
		lp.add(p4);
		mapaDeProyectos.put("Johana Gutierrez", lp);
		
		return mapaDeProyectos;
	}
	
	private static Map<String,List<ItemFactura>> getFacturadosMap(){
		/*** Facturados ***/
		Map <String, List<ItemFactura>> mapaDeFacturados =  new HashMap<>();
		List<ItemFactura> items = new ArrayList<>();
		items.add(new ItemFactura(true, new VersionProducto("CRM","0.5"), 2));
		items.add(new ItemFactura(true, new VersionProducto("CRM","2.1"), 1));
		mapaDeFacturados.put("Coca-Cola", items);
		items = new ArrayList<>();
		
		items.add(new ItemFactura(true, new VersionProducto("PSA BA","1.5"), 1));
		items.add(new ItemFactura(false, new VersionProducto("CRM","2.1"), 5));
		mapaDeFacturados.put("PepsiCO", items);
		items = new ArrayList<>();
		items.add(new ItemFactura(false, new VersionProducto("ERP","1.5"), 10));
		items.add(new ItemFactura(false, new VersionProducto("CRM","2.1"), 4));
		mapaDeFacturados.put("La Serenisima", items);
		items = new ArrayList<>();
		
		items.add(new ItemFactura(false, new VersionProducto("PSA New Spring ERP","0.5"), 7));
		items.add(new ItemFactura(false, new VersionProducto("CRM","2.1"), 9));
		items.add(new ItemFactura(true, new VersionProducto("ERP old","2.5"), 9));
		mapaDeFacturados.put("Johana Gutierrez", items);
		
		return mapaDeFacturados;
		
	}
	
	public List<Cliente> getClients(){
		
		return clientes;
	}
	
	public static List<ItemFactura> getFacturados(String nombre){
		/*** Productos ***/
		return getFacturadosMap().get(nombre);
	}
	
	public static List<Proyecto> getProyectos(String nombre){
		/*** Proyectos ***/
		return getProjectMap().get(nombre);
	}
	
	public void setDestacado(String nombre, Boolean value) {
		for (Cliente cliente : clientes) {
			if(cliente.getNombre().equals(nombre)) {
				cliente.setDestacado(value);
			}
		}
	}
	
	public Cliente getCliente(String nombre) {
		
		for (Cliente cliente : clientes) {
			if(nombre.equals(cliente.getNombre())) {
				return cliente;
			}
		}
		return null;
	}
	
}
