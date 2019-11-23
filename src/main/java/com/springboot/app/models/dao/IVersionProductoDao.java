package com.springboot.app.models.dao;

import java.util.List;

import com.springboot.app.models.entity.VersionProducto;

public interface IVersionProductoDao {
	public List<VersionProducto> findAll();
}
