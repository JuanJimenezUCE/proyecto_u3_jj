package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3JjApplication;
import com.uce.edu.demo.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3JjApplication.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		//TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  FULLER h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		//Bajo demanda
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
		
	
		
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE  h.id= ha.hotel AND ha.tipo =:tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	

	@Override
	//@Transactional(value= TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa Repository: "  + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN FETCH h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}


	@Override
	public Hotel buscarHotel(String tipo) {
		TypedQuery<Hotel> myQuery=this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo= :datoTipo",
				Hotel.class);
		myQuery.setParameter("datoTipo", tipo);
		return myQuery.getSingleResult();
	}
	
	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);
		
	}

	@Override
	public Hotel buscar(Integer id) {
		
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
    public ContadorHabitaciones contarHabitaciones(Integer id, String tipo) {
        //SELECT h.hote_direccion, ha.habi_tipo, COUNT(ha.habi_tipo) as "No Habitaciones" FROM Hotel h INNER JOIN Habitacion ha  GROUP BY ha.habi_tipo, h.hote_id
        TypedQuery<ContadorHabitaciones> myQuery=this.entityManager.createQuery(
                "SELECT NEW com.uce.edu.demo.repository.modelo.ContadorHabitaciones(h.direccion, ha.tipo, COUNT(ha.tipo)) FROM Hotel h JOIN h.habitaciones ha WHERE h.id= :datoId AND ha.tipo= :datoTipo GROUP BY ha.tipo, h.id",
                ContadorHabitaciones.class);
        myQuery.setParameter("datoId", id);
        myQuery.setParameter("datoTipo", tipo);
        return myQuery.getSingleResult();
    }
	

}
