package com.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="productos")
public class VersionProducto implements Serializable{
	
	
	private static final long serialVersionUID = 7082668886203824935L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_version_producto")
	private Integer id_version_producto;
	
	@NotEmpty
	private String nombre_producto;
	@NotEmpty
	private Integer version;
	
	@OneToOne
	@JoinColumn(name="proyecto", referencedColumnName = "nombre_de_proyecto")
	private Proyecto proyecto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
	private Compra compra;
	
	@NotEmpty
	private Date fechaReleaseMercado;

	public String getNombre_producto() {
		return nombre_producto;
	}
	
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Integer getId_version_producto() {
		return id_version_producto;
	}

	public void setId_version_producto(Integer id_version_producto) {
		this.id_version_producto = id_version_producto;
	}

	public Date getFechaReleaseMercado() {
		return fechaReleaseMercado;
	}

	public void setFechaReleaseMercado(Date fechaReleaseMercado) {
		this.fechaReleaseMercado = fechaReleaseMercado;
	}

}


