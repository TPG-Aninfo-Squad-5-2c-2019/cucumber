package com.springboot.app.models.entity;

public class ItemFactura {

	private Boolean facturado;
	
	private VersionProducto item;
	
	private Integer cantidad;
	
	private Double importe_unitario;
	
	public ItemFactura(Boolean facturado, VersionProducto item, Integer cantidad, Double i) {
		super();
		this.facturado = facturado;
		this.item = item;
		this.cantidad = cantidad;
		this.importe_unitario = i;
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

	public VersionProducto getItem() {
		return item;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getImporte_unitario() {
		return importe_unitario;
	}

	public void setImporte_unitario(Double importe_unitario) {
		this.importe_unitario = importe_unitario;
	}

	public Double getImporte_total() {
		return cantidad*importe_unitario;
	}

}
