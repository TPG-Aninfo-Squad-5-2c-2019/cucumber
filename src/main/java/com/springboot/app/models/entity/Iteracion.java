package com.springboot.app.models.entity;

import java.util.Date;
import java.util.List;

public class Iteracion {
	
	private Date fecha_inicio;
	private Date fecha_fin;
	
	List<Tarea> tareas;
	
	public Iteracion(Date fecha_inicio, Date fecha_fin, List<Tarea> features) {
		super();
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		tareas = features;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void addTarea(Tarea tarea) {
		tareas.add(tarea);
	}
	
	public void deleteTarea(Tarea tarea) {
		tareas.remove(tarea);
	}
}
