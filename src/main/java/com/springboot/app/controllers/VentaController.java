package com.springboot.app.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.models.dao.VentaDao;
import com.springboot.app.models.entity.Venta;

public class VentaController {
	
	private VentaDao vdao =  VentaDao.getInstance();
	
	@RequestMapping(value="/sales")
	public String listarVentas(Model m) {
		List<Venta> ventas = vdao.getAll();
		
		m.addAttribute("titulo", "Listado de ventas");
		m.addAttribute("ventas", ventas);
		
		return "sales";
	}
	

}
