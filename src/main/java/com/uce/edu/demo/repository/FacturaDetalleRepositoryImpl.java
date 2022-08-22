package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Detalle;
@Repository
@Transactional
public class FacturaDetalleRepositoryImpl implements IFacturaDetalleRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

}