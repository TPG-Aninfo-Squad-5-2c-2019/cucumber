package com.springboot.app.models.entity;


import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private Integer CUIT;
	
	private String nombre;
	
	private String razon_social;
	
	private String direccion;
	
	private Boolean destacado;
	
	private List <String> telefonos;
	
	private List <ItemFactura> facturados = new ArrayList<>();
	
	private List <SLA> acuerdosNivelDeServicio;
	
	public Cliente(Integer cuit,String nombre, String razon_S, 
		String direccion,List<String> telefonos) {
		CUIT = cuit;
		this.nombre = nombre;
		this.razon_social = razon_S;
		this.direccion = direccion;
		this.telefonos = telefonos;
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public List<ItemFactura> getFacturados() {
		return facturados;
	}
	
	public List<SLA> getSLA(){
		return acuerdosNivelDeServicio;
	}
	
	public void agregarSLA(SLA sla) {
		acuerdosNivelDeServicio.add(sla);
	}
	
	public void agregarFacturado(ItemFactura facturado) {
		facturados.add(facturado);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getCUIT() {
		return CUIT;
	}
	
	public void setCUIT(Integer CUIT) {
		this.CUIT = CUIT;
	}
	
	public String getRazon_social() {
		return razon_social;
	}
	
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	public Boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}
}
