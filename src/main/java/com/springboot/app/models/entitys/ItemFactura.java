package com.springboot.app.models.entitys;

import java.util.Map;

public class ItemFactura {

	private Boolean facturado;
	
	private Object item;
	
	private Integer cantidad;
	
	public ItemFactura(Boolean facturado, Object item, Integer cantidad) {
		super();
		this.facturado = facturado;
		this.item = item;
		this.cantidad = cantidad;
	}

	public void facturar(Boolean estado) {
		if(!facturado)
			facturado = true;
	}
	
	public Boolean getFacturado() {
		return facturado;
	}
	
	public Integer getCantidadFacturada(){
		return cantidad;
	}

	public Object getItem() {
		return item;
	}

	public Integer getCantidad() {
		return cantidad;
	}
}
