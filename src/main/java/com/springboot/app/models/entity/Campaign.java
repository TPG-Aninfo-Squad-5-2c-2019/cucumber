package com.springboot.app.models.entity;

import java.util.List;

public class Campaign {
	
	private String campaign_title;
	
	private String medio_de_difusion;
	
	private String fecha_inicio;
	
	private String fecha_fin;

	private Double presupuesto_aprobado;
	
	private Double presupuesto_final;
	
	private VersionProducto vp;
	
	List<Cliente> clientes;

	public Campaign(String campaign_name, String medio_de_difusion, String fecha_inicio, String fecha_fin,
			Double presupuesto, List<Cliente> clients) {
		super();
		this.campaign_title = campaign_name;
		this.medio_de_difusion = medio_de_difusion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.presupuesto_aprobado = presupuesto;
		clientes = clients;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public String getCampaign_title() {
		return campaign_title;
	}

	public void setCampaign_title(String campaign_name) {
		this.campaign_title = campaign_name;
	}

	public String getMedio_de_difusion() {
		return medio_de_difusion;
	}

	public void setMedio_de_difusion(String medio_de_difusion) {
		this.medio_de_difusion = medio_de_difusion;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public VersionProducto getVp() {
		return vp;
	}

	public void setVp(VersionProducto vp) {
		this.vp = vp;
	}

	public Double getPresupuesto_final() {
		return presupuesto_final;
	}

	public void setPresupuesto_final(Double presupuesto_final) {
		this.presupuesto_final = presupuesto_final;
	}

	public Double getPresupuesto_aprobado() {
		return presupuesto_aprobado;
	}

	
}
