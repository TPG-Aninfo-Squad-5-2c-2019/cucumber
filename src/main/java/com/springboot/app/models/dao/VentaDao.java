package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.Venta;
import com.springboot.app.models.entity.VersionProducto;

public class VentaDao {
	
	private static VentaDao ventaDao = null;
	
	private static List<Venta> ventas =  new ArrayList<>();
	
	public static VentaDao getInstance() {
		if(ventaDao == null) {
			ventaDao =  new VentaDao();
			
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("CRM","1.5"),
													 1, 13.000), new Cliente("Swiss Sa"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(true, new VersionProducto("ERP","0.5"),
													 2, 12.000), new Cliente("Firma SA"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 2, 50.000), new Cliente("Marcelo G"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 2, 14.000), new Cliente("Firma SA"),"1-11-2019"));										 
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 2, 20.000), new Cliente("La Serenisima"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("PSA New Spring ERP","0.5"),
													 3, 10.000), new Cliente("Sa Pastel"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(true, new VersionProducto("ERP","0.5"),
													 4, 22.000), new Cliente("Coca-Cola"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("PSA New Spring ERP","1.5"),
													 5, 50.000), new Cliente("Gobierno nacional"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 7, 4.000), new Cliente("Firma SA"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 100, 50.000), new Cliente("Swiss Sa"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("PSA New Spring ERP","2.5"),
													 20, 50.000), new Cliente("Firma SA"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 4, 50.000), new Cliente("Swiss Sa"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(true, new VersionProducto("CRM","8.0"),
													 8, 50.000), new Cliente("Coca-Cola"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 10, 5.000), new Cliente("Swiss Sa"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("CRM","5.0"),
													 2, 50.000), new Cliente("Gobierno nacional"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("ERP","0.5"),
													 3, 6.000), new Cliente("Coca-Cola"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(true, new VersionProducto("ERP","0.5"),
													 50, 7.000), new Cliente("Firma SA"),"1-11-2019"));
			ventas.add(new Venta(new ItemFactura(false, new VersionProducto("CRM","8.0"),
													 8, 5.000), new Cliente("Marcela H"),"1-11-2019"));
													 
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
