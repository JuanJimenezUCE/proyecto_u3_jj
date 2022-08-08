package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f  JOIN f.detalles de WHERE de.cantidad <: cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f  JOIN f.detalles de ",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f  LEFT JOIN f.detalles de WHERE de.cantidad <: cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f  LEFT JOIN f.detalles de ", Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f  RIGHT JOIN f.detalles de WHERE de.cantidad <: cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura de  WHERE f.id = de.factura AND de.cantidad <: cantidad",
				Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f  JOIN FETCH f.detalles de WHERE de.cantidad <: cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

}
