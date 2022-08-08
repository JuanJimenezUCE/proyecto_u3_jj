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

		
		
		LOG.info("INNER JOIN");
		List<Factura> listaFacturas =this.iFacturaService.buscarFacturaInnerJoin(5);
		
		for (Factura f : listaFacturas) {
			LOG.info("Factura : " + f.getNumero()+" "+f.getFecha());
		}
		
		List<Factura> listaFacturas2 =this.iFacturaService.buscarFacturaInnerJoin();
		
		for (Factura f : listaFacturas2) {
			LOG.info("Factura 2: " + f.getNumero()+" "+f.getFecha());
		}
		
		//Left
		LOG.info("LEFT JOIN");
		List<Factura> listaFacturasLeft =this.iFacturaService.buscarFacturaOuterJoinLeft(5);
		
		for (Factura f : listaFacturasLeft) {
			LOG.info("Factura : " + f.getNumero()+" "+f.getFecha());
		}
		
		List<Factura> listaHotelesLeft2 =this.iFacturaService.buscarFacturaOuterJoinLeft();
		
		for (Factura f : listaHotelesLeft2) {
			LOG.info("Factura 2: " + f.getNumero()+" "+f.getFecha());
		}
		
		//Right
		LOG.info("RIGHT JOIN");
		List<Factura> listaHotelesRight =this.iFacturaService.buscarFacturaOuterJoinRight(5);
		
		for (Factura f : listaHotelesRight) {
			LOG.info("Factura : " + f.getNumero()+" "+f.getFecha());
		}
		
		
		
	}

}
