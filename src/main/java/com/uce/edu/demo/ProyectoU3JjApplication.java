package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3JjApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3JjApplication.class);
	
	@Autowired
	private IHotelService iHotelService;
	@Autowired
	private IFacturaService iFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaFacturas =this.iFacturaService.buscarFacturaJoinWhere(5);
		
		for (Factura f : listaFacturas) {
			LOG.info("Factura : " + f.getNumero()+" "+f.getFecha());
		}
		

		LOG.info(" JOIN FETCH");
		
		List<Factura> listaFacturas2 =this.iFacturaService.buscarFacturaJoinFetch(5);

		for (Factura f : listaFacturas2) {
			LOG.info("Factura FETCH: " + f.getNumero()+" "+f.getFecha());
			for(DetalleFactura de : f.getDetalles()) {
			
			LOG.info("Detalles : " +de);
			
			}
		}
		
		
		/*
		LOG.info("RELACIONAMIENTO WHERE");
		List<Hotel> listaHoteles =this.iHotelService.buscarHotelJoinWhere("Familiar");
		
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel : " + h.getNombre()+" "+h.getDireccion());
		}
		

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
