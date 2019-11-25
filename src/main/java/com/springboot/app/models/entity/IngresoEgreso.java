package com.springboot.app.models.entity;

import java.io.Serializable;


public class IngresoEgreso implements Serializable{

    /**
		 * 
		 */
        private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String empresa;
	private String concepto;
	private String monto;
    
    public IngresoEgreso(String tipo, String empresa, String concepto, String monto) {
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
    
    public String getMonto() {
		return this.monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
    }
    
    public String getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
