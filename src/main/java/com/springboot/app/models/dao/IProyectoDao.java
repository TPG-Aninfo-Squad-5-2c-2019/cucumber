package com.springboot.app.models.dao;

import java.util.List;

import com.springboot.app.models.entity.Proyecto;

public interface IProyectoDao {
	
	public List<Proyecto> findAll();

}
