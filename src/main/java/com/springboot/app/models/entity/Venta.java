package com.springboot.app.models.entity;

public class Venta {
	
	private ItemFactura itemVendido;
	
	private String fechaVendido;

	private Cliente comprador;

	public Venta(ItemFactura productoVendido, Cliente comprador, String fechaVendido) {
		super();
		this.itemVendido = productoVendido;
		this.comprador = comprador;
	}

	public String getFechaVendido() {
		return fechaVendido;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public ItemFactura getItemVendido() {
		return itemVendido;
	}
	
}
