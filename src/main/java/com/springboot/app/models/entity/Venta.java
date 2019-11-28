package com.springboot.app.models.entity;

public class Venta {
	
	private VersionProducto productoVendido;
	
	private String fechaVendido;
	
	private String estadoFacturacion;
	
	private Integer cantidadVendida;
	
	private Cliente comprador;

	public Venta(VersionProducto productoVendido, Cliente comprador, String fechaVendido, 
			String estadoFacturacion, Integer cantidad) {
		super();
		this.productoVendido = productoVendido;
		this.comprador = comprador;
		this.setEstadoFacturacion(estadoFacturacion);
		this.cantidadVendida = cantidad;
	}

	public String getFechaVendido() {
		return fechaVendido;
	}
	
	public String getEstadoFacturacion() {
		return estadoFacturacion;
	}

	public void setEstadoFacturacion(String estadoFacturacion) {
		this.estadoFacturacion = estadoFacturacion;
	}

	public VersionProducto getProductoVendido() {
		return productoVendido;
	}

	public Integer getCantidadVendida() {
		return cantidadVendida;
	}

	public Cliente getComprador() {
		return comprador;
	}
	
}
