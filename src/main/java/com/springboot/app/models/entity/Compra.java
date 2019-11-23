package com.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2715804574458255227L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Integer id_compra;
	
	@ManyToOne
	@JoinColumn(name = "CUIT",referencedColumnName = "CUIT")
	private Cliente cliente;	
	
	@OneToOne(mappedBy = "compra")
	private VersionProducto vp;
	
	private Integer cantidad;

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
