package com.springboot.app.controllers;

import java.util.List;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.entity.ItemFactura;
import com.springboot.app.models.entity.VersionProducto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.VentaDao;
import com.springboot.app.models.entity.Venta;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VentaController {
	
	private VentaDao vdao =  VentaDao.getInstance();
	
	@RequestMapping(value="/sales", method= RequestMethod.GET)
	public String listarVentas(Model m) {
		List<Venta> ventas = vdao.getAll();

		m.addAttribute("titulo", "Listado de ventas");
		m.addAttribute("ventas", ventas);
		
		return "sales";
	}

	@RequestMapping(value="/sales/add", method=RequestMethod.POST)
	public RedirectView nuevaVenta(HttpServletRequest request,
							 @RequestParam(value="producto") String producto,
							 @RequestParam(value="version") String version,
							 @RequestParam(value="cantidad") Integer cantidad,
							 @RequestParam(value="monto") Double monto,
							 @RequestParam(value="cliente") String cliente,
							 @RequestParam(value="fecha") String fecha) {

		Venta venta = new Venta(new ItemFactura(false, new VersionProducto(producto,version),cantidad, monto), new Cliente(cliente),fecha);
		vdao.agregarVenta(venta);
		return new RedirectView("/sales");
	}
}
