package com.springboot.app.models.entity;

import java.util.List;

public class VersionProducto{
	
	private String nombre;

	private String version;
	
	private String descripcion;
	
	private String estado;

	private String fechaReleaseMercado;
	
	private List<String> features;
	
	private String comentarios;

	public VersionProducto(String nombre_producto, String version) {
		super();
		this.nombre = nombre_producto;
		this.version = version;
		setEstado("0%");
	}

	public VersionProducto(String nombre_producto, String version, String fechaReleaseMercado, List<String> features) {
		super();
		this.nombre = nombre_producto;
		this.version = version;
		this.fechaReleaseMercado = fechaReleaseMercado;
		this.features = features;
		setEstado("0%");
	}

	public VersionProducto() {
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre_producto) {
		this.nombre = nombre_producto;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFechaReleaseMercado() {
		return fechaReleaseMercado;
	}

	public void setFechaReleaseMercado(String fechaReleaseMercado) {
		this.fechaReleaseMercado = fechaReleaseMercado;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}


