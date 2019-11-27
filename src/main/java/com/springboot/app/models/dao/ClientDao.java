package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.Proyecto;
import com.springboot.app.models.entity.VersionProducto;

public class ClientDao {
	
	public static List<Cliente> getClients() {

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
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente pepsiCo = new Cliente(50123151,"PepsiCO","PepsiCo-SRL","Cazadores-2860- Munro",
									telefonos_PepsiCo);
		Cliente CocaCola = new Cliente(5131231,"Coca-Cola", "Coca-Cola-Femsa-de-BA",
										"Av.-Amancio-Alcorta-3570-C1437-CABA",telefonos_Coca_Cola);
		Cliente LaSerenisima = new Cliente(53431121,"La_Serenisima'","Logistica-La-Serenisima" ,
									"Moreno 877 C1091AAQ CABA",telefonos_La_Serenisima);
		Cliente Jane = new Cliente(65431312,"Jane","","Cerrito-2020-CABA",telefonos_Jane);
		
		/*** Facturados ***/
		
		CocaCola.agregarFacturado(new ItemFactura(true, new VersionProducto("CRM","0.5"), 2));
		CocaCola.agregarFacturado(new ItemFactura(true, new VersionProducto("CRM","2.1"), 1));	
		pepsiCo.agregarFacturado(new ItemFactura(true, new VersionProducto("PSA BA","0.5"), 1));
		pepsiCo.agregarFacturado(new ItemFactura(false, new VersionProducto("CRM","2.1"), 5));
		
		clientes.add(pepsiCo);
		clientes.add(CocaCola);
		clientes.add(LaSerenisima);
		clientes.add(Jane);
		
		return clientes;
	}
	
	public static List<Proyecto> getProyectos(Integer numeroDeCliente){
		/*** Proyectos ***/
		List<Proyecto> proyectos= new ArrayList<>();
		Proyecto p1 = new Proyecto("PSA BA 1.1", "Customización", "En proceso");
		Proyecto p2 = new Proyecto("PSA CRM 1.0", "Implementación", "En proceso");
		Proyecto p3 = new Proyecto("PSA New Spring ERP 3.0","Customización","En proceso");
		Proyecto p4 = new Proyecto("PSA BA 1.0","Desarrollo","Finalizado");
		
		if(numeroDeCliente == 0) {
			proyectos.add(p1);
			proyectos.add(p2);
			return proyectos;
		}
		
		proyectos.add(p3);
		proyectos.add(p4);
		return proyectos;
	}
	
}
