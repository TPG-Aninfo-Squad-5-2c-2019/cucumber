package com.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.models.entity.VersionProducto;

@Repository
public class VersionProductoDao  implements IVersionProductoDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<VersionProducto> findAll() {
		return em.createQuery("from VersionProducto").getResultList();
	}

}
