package com.springboot.app.models.entity;

public class IngresoEgreso{

	private String tipo;
	private String empresa;
	private String concepto;
	private Double monto;
	
	public IngresoEgreso() {}
	
    public IngresoEgreso(String tipo, String empresa, String concepto, Double monto) {
        this.tipo = tipo;
        this.empresa = empresa;
        this.concepto = concepto;
        this.monto = monto;
    }

	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
    }

    public String getConcepto() {
		return this.concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
    
    public Double getMonto() {
		return this.monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
    }
    
    public String getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}