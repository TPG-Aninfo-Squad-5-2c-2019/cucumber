package com.springboot.app.models.entitys;

import java.util.List;

public class SLA {
	
	private List<VersionProducto> productos;
	
	private String contratoDeSoporteYMantenimiento;

	public SLA(List<VersionProducto> productos, String contratoDeSoporteYMantenimiento) {
		super();
		this.productos = productos;
		this.contratoDeSoporteYMantenimiento = contratoDeSoporteYMantenimiento;
	}
	
	public List<VersionProducto> getProductos() {
		return productos;
	}

	public String setContratoDeSoporteYMantenimiento() {
		return contratoDeSoporteYMantenimiento;
	}

}
