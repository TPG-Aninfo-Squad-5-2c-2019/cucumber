package com.springboot.app.models.entity;

import java.sql.Time;
import java.util.Date;

public class Tarea {
	
	private String titulo;
	
	private Date fecha_inicio;
	
	private Date fecha_limite;
	
	private String descripcion;
	
	private String prioridad;
	
	private String estado;
	
	private String comentarios;
	
	private Time horasInsumidas;
	
	private Time horasEstimadas;
	
	public Tarea(String titulo, Date fecha_inicio, Date fecha_limite, 
			String descripcion, String prioridad, String estado) {
		super();
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_limite = fecha_limite;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_limite() {
		return fecha_limite;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Time getHorasInsumidas() {
		return horasInsumidas;
	}

	public void setHorasInsumidas(Time horasInsumidas) {
		this.horasInsumidas = horasInsumidas;
	}

	public Time getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(Time horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

}
