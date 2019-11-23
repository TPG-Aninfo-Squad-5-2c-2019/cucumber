package com.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.models.entity.Proyecto;

@Repository
public class ProyectoDao implements IProyectoDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Proyecto> findAll() {
		return em.createQuery("from Proyecto").getResultList();
	}
}
