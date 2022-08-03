package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3JjApplication.class);
	
	@Autowired
	private IHotelService iHotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("INNER JOIN");
		List<Hotel> listaHoteles =this.iHotelService.buscarHotelInnerJoin("Matrimonial");
		
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel : " + h.getNombre()+" "+h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 =this.iHotelService.buscarHotelInnerJoin();
		
		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel2 : " + h.getNombre()+" "+h.getDireccion());
		}
		
		//Left
		LOG.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft =this.iHotelService.buscarHotelOuterJoinLeft("Matrimonial");
		
		for (Hotel h : listaHotelesLeft) {
			LOG.info("Hotel : " + h.getNombre()+" "+h.getDireccion());
		}
		
		List<Hotel> listaHotelesLeft2 =this.iHotelService.buscarHotelOuterJoinLeft();
		
		for (Hotel h : listaHotelesLeft2) {
			LOG.info("Hotel2 : " + h.getNombre()+" "+h.getDireccion());
		}
		
		//Right
		LOG.info("RIGHT JOIN");
		List<Hotel> listaHotelesRight =this.iHotelService.buscarHotelOuterJoinRight("Matrimonial");
		
		for (Hotel h : listaHotelesRight) {
			LOG.info("Hotel : " + h.getNombre()+" "+h.getDireccion());
		}
		
		
		
		
	}

}
