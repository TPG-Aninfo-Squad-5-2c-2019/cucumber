package com.springboot.app.models.entity;

import java.util.Date;
import java.util.List;

public class Proyecto{
	
	private Integer presupuestoPactado;
	
	private String nombre_de_proyecto;

	private VersionProducto productoVersion;

	private String tipo_de_proyecto;
	 
	private Date fecha_de_inicio;

	private Date fecha_de_finalizacion;

	private String estado;
	
	private Integer presupuestoGastado;
	
	private Cliente clienteAsociado;
	
	private List<Iteracion> iteraciones;

	public Proyecto(String nombre_de_proyecto, VersionProducto productoVersion, 
			String tipo_de_proyecto,
			Date fecha_de_inicio, Date fecha_de_finalizacion, 
			String estado, Integer presupuesto, Cliente clienteAsociado) {
		super();
		this.nombre_de_proyecto = nombre_de_proyecto;
		this.productoVersion = productoVersion;
		this.tipo_de_proyecto = tipo_de_proyecto;
		this.fecha_de_inicio = fecha_de_inicio;
		this.fecha_de_finalizacion = fecha_de_finalizacion;
		this.estado = estado;
		this.presupuestoPactado = presupuesto;
		this.presupuestoGastado = 0;
		this.clienteAsociado = clienteAsociado;
	}

	public Proyecto(String nombre_de_proyecto, String tipo_de_proyecto, String estado) {
		super();
		this.nombre_de_proyecto = nombre_de_proyecto;
		this.tipo_de_proyecto = tipo_de_proyecto;
		this.estado = estado;
	}
	
	public Proyecto(VersionProducto productoVersion, String estado) {
		super();
		this.productoVersion = productoVersion;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre_de_proyecto;
	}

	public void setNombre(String nombre) {
		this.nombre_de_proyecto = nombre;
	}

	public String getTipo_de_proyecto() {
		return tipo_de_proyecto;
	}

	public void setTipo_de_proyecto(String tipo_de_proyecto) {
		this.tipo_de_proyecto = tipo_de_proyecto;
	}

	public Date getFecha_de_inicio() {
		return fecha_de_inicio;
	}

	public void setFecha_de_inicio(Date fecha_de_inicio) {
		this.fecha_de_inicio = fecha_de_inicio;
	}

	public Date getFecha_de_finalizacion() {
		return fecha_de_finalizacion;
	}

	public void setFecha_de_finalizacion(Date fecha_de_finalizacion) {
		this.fecha_de_finalizacion = fecha_de_finalizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public VersionProducto getProductoVersion() {
		return productoVersion;
	}

	public void setProductoVersion(VersionProducto productoVersion) {
		this.productoVersion = productoVersion;
	}

	public Integer getPresupuestoPactado() {
		return presupuestoPactado;
	}

	public Integer getPresupuestoGastado() {
		return presupuestoGastado;
	}

	public void agregarAlPresupuestoGastado(Integer montoOcupado) {
		if(montoOcupado > 0)
			this.presupuestoGastado += montoOcupado;
	}

	public List<Iteracion> getIteraciones() {
		return iteraciones;
	}
	
	public void addIteracion(Iteracion sprint) {
		iteraciones.add(sprint);
	}

	public Cliente getClienteAsociado() {
		return clienteAsociado;
	}

	public void setClienteAsociado(Cliente clienteAsociado) {
		this.clienteAsociado = clienteAsociado;
	}
	
}
