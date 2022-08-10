package com.uce.edu.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3JjApplication;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService{

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
		
		LOG.info("Transaccion activa: "  + org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());
		return this.iHotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}





}
