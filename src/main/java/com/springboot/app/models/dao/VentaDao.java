package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.Venta;
import com.springboot.app.models.entity.VersionProducto;

public class VentaDao {
	
	private static VentaDao ventaDao = null;
	
	private static List<Venta> ventas =  new ArrayList<>();
	
	public static VentaDao getInstance() {
		if(ventaDao == null) {
			ventaDao =  new VentaDao();
			
			ventas.add(new Venta(new VersionProducto("CRM","1.5"), new Cliente("Gobierno nacional"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("ERP","0.5"), new Cliente("Firma SA"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("PSA BA","1.5"), new Cliente("Sa Pastel"),"1-11-2019", "sin facturar", 1));
			ventas.add(new Venta(new VersionProducto("CRM","0.5"), new Cliente("Swiss Sa"),"1-11-2019", "facturado", 10));
			ventas.add(new Venta(new VersionProducto("BA","0.5"), new Cliente("Swiss Sa"),"1-11-2019", "sin facturar", 3));
			ventas.add(new Venta(new VersionProducto("ERP","1.3"), new Cliente("Firma SA"),"1-11-2019", "sin facturar", 100));
			ventas.add(new Venta(new VersionProducto("CRM","0.1"), new Cliente("PepsiCo"),"1-11-2019", "sin facturar", 10));
			ventas.add(new Venta(new VersionProducto("ERP","0.5"), new Cliente("PepsiCo"),"1-11-2019", "facturado", 2));
			ventas.add(new Venta(new VersionProducto("PSA New Spring ERP","0.5"), new Cliente("Marcela H"),"1-11-2019", "sin facturar", 20));
			ventas.add(new Venta(new VersionProducto("ERP","2.4"), new Cliente("PepsiCo"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("CRM","0.5"), new Cliente("Coca-Cola"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("ERP","0.5"), new Cliente("Eduardo P"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("CRM","5.6"), new Cliente("PepsiCo"),"1-11-2019", "facturado", 9));
			ventas.add(new Venta(new VersionProducto("CRM","0.5"), new Cliente("Coca-Cola"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("ERP","0.5"), new Cliente("Marcela H"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("PSA New Spring ERP","0.5"), new Cliente("Marcela H"),"1-11-2019", "sin facturar", 2));
			ventas.add(new Venta(new VersionProducto("PSA New Spring ERP","0.5"), new Cliente("Coca-Cola"),"1-11-2019", "sin facturar", 5));
			ventas.add(new Venta(new VersionProducto("ERP","5.8"), new Cliente("Gobierno nacional"),"1-11-2019", "facturado", 2));
			ventas.add(new Venta(new VersionProducto("CRM","8.0"), new Cliente("Marcelo G"),"1-11-2019", "sin facturar", 9));
			ventas.add(new Venta(new VersionProducto("ERP","0.5"), new Cliente("Coca-Cola"),"1-11-2019", "sin facturar", 1));
			ventas.add(new Venta(new VersionProducto("CRM","1.0"), new Cliente("Cristina K"),"1-11-2019", "facturado", 2));
			ventas.add(new Venta(new VersionProducto("BA","5.6"), new Cliente("MM"),"1-11-2019", "sin facturar", 8));
			ventas.add(new Venta(new VersionProducto("CRM","0.5"), new Cliente("La Serenisima"),"1-11-2019", "sin facturar", 4));
			ventas.add(new Venta(new VersionProducto("ERP","4.5"), new Cliente("Johana Gutierrez"),"1-11-2019", "sin facturar", 2));
			
		}
		return ventaDao;
	}
	
	public void agregarVenta(Venta venta) {
		ventas.add(venta);
	}
	
	public List<Venta> getAll(){
		return ventas;
	}

}
