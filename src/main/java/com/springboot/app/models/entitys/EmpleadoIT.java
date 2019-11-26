package com.springboot.app.models.entitys;

import java.util.List;

public class EmpleadoIT {
	
	private String nombre;
	
	private String seniority;
	
	List<String> skills;
	
	List<Tarea> tareas;
	
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
	
}
