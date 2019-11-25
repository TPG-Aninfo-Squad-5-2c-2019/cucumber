package com.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_proyecto;
	
	@NotEmpty
	private String nombre_de_proyecto;
	
	@OneToOne(mappedBy="proyecto")
	private VersionProducto productoVersion;
	
	@NotEmpty
	private String tipo_de_proyecto;
	 
	@NotEmpty
	private Date fecha_de_inicio;
	
	@NotEmpty
	private Date fecha_de_finalizacion;
	
	@NotEmpty
	private String estado;

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
	
}
