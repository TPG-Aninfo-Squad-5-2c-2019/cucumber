package com.springboot.app.models.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpleadoIT {
	
	private String nombre;
	
	private String seniority;
	
	List<String> skills;
	
	List<Tarea> tareas;

	Map<String, Integer> productividadPorProyecto = new HashMap<String, Integer>();
	
	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public EmpleadoIT(String nombre, String seniority, List<String> skills) {
		super();
		this.nombre = nombre;
		this.seniority = seniority;
		this.skills = skills;
	}

	public EmpleadoIT(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getSeniority() {
		return this.seniority;
	}

	public List<String> getSkills(){
		return skills;
	}
	
	public void addSkill(String newSkill) {
		skills.add(newSkill);
	}
	
	public void upgradeSeniority(String newSeniority) {
		this.seniority = newSeniority;
	}
	
	public void addProductividadPorProyecto(String nombreProyecto, Integer productividad) {
		productividadPorProyecto.put(nombreProyecto, productividad);
	}

	public Map<String, Integer> getDataProductividad() {
		return this.productividadPorProyecto;
	}
}
