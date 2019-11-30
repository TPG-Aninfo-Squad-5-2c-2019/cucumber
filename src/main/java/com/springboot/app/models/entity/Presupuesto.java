package com.springboot.app.models.entity;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Presupuesto {
	
	@NotNull
	private String fecha;
	
	@DecimalMax("20000.0") @DecimalMin("0.0") 
	private Double monto;

	public Presupuesto(String fecha, Double monto) {
		super();
		this.fecha = fecha;
		this.monto = monto;
	}

	public Presupuesto() {
		//this.fecha = "";
		this.monto = 0.0;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
