package com.springboot.app.models.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Campaign {
	
	private String campaign_title;
	
	private String medio_de_difusion;
	
	private String fecha_inicio;
	
	private String fecha_fin;
	
	private List<Presupuesto> presupuestosAprobados = new ArrayList<>();
	
	private List<Presupuesto> presupuestosUtilizados = new ArrayList<>();

	public Campaign(String campaign_name, String medio_de_difusion,
			String fecha_inicio, String fecha_fin, 
			List<Presupuesto> presupuestosAprobados){
		super();
		this.campaign_title = campaign_name;
		this.medio_de_difusion = medio_de_difusion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.presupuestosAprobados = presupuestosAprobados;
		for (Presupuesto pres: presupuestosAprobados){
			Presupuesto presupuestoNuevo = new Presupuesto();
			presupuestoNuevo.setFecha(pres.getFecha());
			presupuestosUtilizados.add(presupuestoNuevo);
		}
	}

	public Campaign(){
		
	}

	public void setPresupuestosAprobados(List<Presupuesto> presupuestosAprobados) {
		this.presupuestosAprobados = presupuestosAprobados;
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
	
	private Double getTotal(List<Presupuesto> collection) {
		Double total = 0.0;
		for (Presupuesto pres: collection) {
			total+=pres.getMonto();
		}
		return total;
	}
	
	public List<Presupuesto> getPresupuestosAprobados(){
	
		return presupuestosAprobados;
	}
	
	public List<Presupuesto> getPresupuestosReales(){
		
		return presupuestosUtilizados;
	}
	
	public void setPresupuestoUtilizado(String fecha, Double presupuesto) {
		
		Boolean encontrado = false;
		while(!encontrado )
		for (Presupuesto pres : presupuestosUtilizados) {
			if(pres.getFecha().equals(fecha)) {
				pres.setMonto(presupuesto);
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			presupuestosUtilizados.add(new Presupuesto(fecha,presupuesto));
		}
	}

	public Double getPresupuesto_total_aprobado() {
		
		return getTotal(presupuestosAprobados);
	}

	public Double getPresupuesto_total_real() {
		return getTotal(presupuestosUtilizados);
	}
	
}
