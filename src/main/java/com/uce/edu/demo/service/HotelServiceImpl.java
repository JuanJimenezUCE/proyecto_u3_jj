package com.uce.edu.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU3JjApplication;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3JjApplication.class);

	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override

	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub

		LOG.info("Transaccion activa: " + org.springframework.transaction.support.TransactionSynchronizationManager
				.isActualTransactionActive());
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

	@Override
	public void insertar(Hotel h) {
		this.iHotelRepository.insertar(h);

	}

	@Override
	public Hotel buscarHotel(String tipo) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.buscarHotel(tipo);
	}

	@Override
	public ContadorHabitaciones contarHabitaciones(Integer id, String tipo) {
		return this.iHotelRepository.contarHabitaciones(id, tipo);
	}

}
