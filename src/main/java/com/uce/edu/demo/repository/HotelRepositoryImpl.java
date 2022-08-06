package com.uce.edu.demo.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  FULLER h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}

		return hoteles;
	}
	
	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}

		return myQuery.getResultList();
	}
	
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN h.habitaciones ha ",Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  LEFT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  LEFT JOIN h.habitaciones ha ",Hotel.class);
	
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  RIGHT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
	
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h.id= ha.hotel AND ha.tipo =:tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN FETCH h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}



	
}
