package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3JjApplication.class);
	
	@Autowired
	private IHotelService iHotelService;
	@Autowired
	private IFacturaService iFacturaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		this.iTransferenciaService.realizarTransferenciaFachada("131213", "32165", new BigDecimal(8));
		
		
		
		
		
/*
		LOG.info(" JOIN FETCH");
		
		List<Hotel> listaHoteles2 =this.iHotelService.buscarHotelJoinFetch("Familiar");

		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel 3: " + h.getNombre()+" "+h.getDireccion());
			for(Habitacion ha :h.getHabitaciones()) {

			LOG.info("Habitacion 3: " +ha);

			}
		}
		
		*/
		
	}

}
