package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.Cliente;

public class ClienteDestacadoDao {
	
	ClientDao cdao = ClientDao.getInstance();

	private List<Cliente> clientes = new ArrayList<>();
	
	private static ClienteDestacadoDao cdDao =  null;
	
	public static ClienteDestacadoDao getInstance() {
		
		if(cdDao == null) {
			cdDao = new ClienteDestacadoDao();
		}
		
		return cdDao;
		
	}
	
	public void agregarCliente(String nombre) {
		cdao.setDestacado(nombre, true);
		clientes.add(cdao.getCliente(nombre));
	}
	
	public List<Cliente> getAll(){
		return clientes;
	}
	
	public void eliminarCliente(String nombreCliente) {
		
		Cliente aEliminar = null;
		
		cdao.setDestacado(nombreCliente, false);
		
		for (Cliente cliente : clientes) {
			if(nombreCliente.equals(cliente.getNombre())) {
				aEliminar = cliente;
				break;
			}
		}
		
		clientes.remove(aEliminar);
	}
}
