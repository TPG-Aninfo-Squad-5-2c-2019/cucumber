package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.Presupuesto;

public class PresupuestoCreationDTO {
	
	private List<Presupuesto> presupuestos =  new ArrayList<>();
	 
	    // default and parameterized constructor
	 
	    public void addPresupuesto(Presupuesto presupuesto) {
	        this.presupuestos.add(presupuesto);
	    }
	    
	    public List<Presupuesto> getPresupuestos() {
			return presupuestos;
		}

		public void setPresupuestos(List<Presupuesto> presupuestos) {
			this.presupuestos = presupuestos;
		}

}
