package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.VersionProducto;

public class VersionProductoDao {
	
	private static VersionProductoDao vdDao = null;
	
	List<VersionProducto> productosExistentes = new ArrayList<>();
	
	public VersionProductoDao getInstance() {
		if(vdDao ==  null) {
			vdDao =  new VersionProductoDao();
			productosExistentes.add(new VersionProducto("CRM","0.5"));
			productosExistentes.add(new VersionProducto("CRM","2.1"));
			productosExistentes.add(new VersionProducto("CRM","2.1"));
			productosExistentes.add(new VersionProducto("ERP","1.5"));
			productosExistentes.add(new VersionProducto("PSA New Spring ERP","0.5"));
			productosExistentes.add(new VersionProducto("ERP","1.5"));
		}
		return vdDao;
	}
	
	public void addProducto(VersionProducto p) {
		productosExistentes.add(p);
	}
	
	public VersionProducto getProducto(String nombre) {
		for (VersionProducto versionProducto : productosExistentes) {
			if(versionProducto.getNombre().equals(nombre)) {
				return versionProducto;
			}
		}
		return null;
	}

}
