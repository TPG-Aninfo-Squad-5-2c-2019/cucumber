package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entitys.Campaign;
import com.springboot.app.models.entitys.Cliente;
import com.springboot.app.models.entitys.VersionProducto;

public class CampaignDao {
	
	public static List<Campaign> getCampaigns() {
		/*** Campaign 1 ***/
    	List <String> features =  new ArrayList<String>();
    	features.add("Dashboards: ahora la nueva versión posee dashboards descriptivos");
    	features.add("CRM & Sales: actualizada la vieja versión que se conectaba con el sistema PSA CRM 2.0");
    	features.add("Purchasing: añadido módulo de purchasing agilizando los ciclos de compra y proceso");
    	
    	VersionProducto p = new VersionProducto("ERP","3.0");
    	p.setDescripcion("PSA New Spring ERP es un software de gestión empresarial que permite planificar "
		    			+ "y controlar los procesos y recursos de negocio de una empresa. "
		    			+ "Trata de conseguir que todos los datos de la compañía estén integrados y conectados...");
    	p.setFeatures(features);
    	p.setEstado("78%");
    	p.setFechaReleaseMercado("12/02/2020");
    	
    	List<Cliente> clientes = new ArrayList<>();
    	clientes.add(new Cliente("Coca-Cola"));
    	clientes.add(new Cliente("Logistica La Serenisima"));
    	
    	Campaign c1 = new Campaign("Publicitar New Spring ERP 3.0","Google Ads","10/10/2019","12/12/2019",100.000,clientes);
    	c1.setVp(p);
    	c1.setPresupuesto_final(150.000);
    	
    	/*** Campaign 2 ***/
    	List <String> features2 =  new ArrayList<String>();
    	features2.add("Las funciones de administración de campañas le permiten "
    			+ "administrar toda su "
    			+ "campaña de ventas desde una sola interfaz de usuario.");
    	
    	VersionProducto p2 = new VersionProducto("PSA CRM","2.1");
    	p2.setDescripcion("Con el fin de conocer mejor a tu mercado objetivo, promover"
    			+ " el denominado Marketing Relacional y favorecer las relaciones con "
    			+ "tus clientes, en los últimos años se han desarrollado nuevos instrumentos "
    			+ "tecnológicos, conocidos como CRM. Los sistemas CRM, siglas de Customer "
    			+ "Relationship Management (Administración de la Relación con los Clientes), "
    			+ "son herramientas informáticas creadas para apoyar la gestión de clientes"
    			+ " en las organizaciones. ");
    	p2.setFeatures(features2);
    	p2.setEstado("100%");
    	p2.setFechaReleaseMercado("01/01/2020");
    	
    	List<Cliente> clientes2 = new ArrayList<>();
    	clientes2.add(new Cliente("Citroen"));
    	clientes2.add(new Cliente("PepsiCo"));
    	clientes2.add(new Cliente("Manaos"));
    	
    	Campaign c2 = new Campaign("Publicitar CRM 2.1","Banners en apps móviles","9/10/2019","11/12/2019",95.000,clientes2);
    	c2.setVp(p2);
    	c2.setPresupuesto_final(100.000);
    	
    	/****/
    	List<Campaign> campaigns = new ArrayList<>();
    	campaigns.add(c1);
    	campaigns.add(c2);
    	
    	return campaigns;
	}

}
