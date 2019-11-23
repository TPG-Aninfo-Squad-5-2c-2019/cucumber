package com.springboot.app.models.dao;

import java.util.List;

import com.springboot.app.models.entity.Compra;

public interface ICompraDao {

	List<Compra> findAll();

}
