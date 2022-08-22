package com.uce.edu.demo.service;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@SpringBootTest
class FacturaServiceImplTest {

	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IFacturaService facturaService;
	@Test
	void testConsultar() {
		Factura f=new Factura();
		f.setId(2);
		f.setNumero("1020");
		f.setFecha(LocalDateTime.of(2022, 7, 21, 0, 0));
	//	f.setTotal(new BigDecimal(7.6));
		
		Factura f2=this.facturaService.consultar(2);
		
		Factura f3=this.facturaRepository.consultar(2);
		
		assertEquals(f.getNumero(),f2.getNumero());
		//assertNotSame(f2, f3);
	}
	//Test 3
	@Test
	void testCalcularPrecio() {

			
			BigDecimal valor=this.facturaService.calcularPrecio(1);
			
			Double valorReal=valor.doubleValue();
			Double valorEsperado=9.45;
			
			assertEquals(valorEsperado, valorReal);
		
	}

	@Test
	void testCantidad() {
		assertTrue(this.facturaService.cantidad(1)>3);
		assertFalse(this.facturaService.cantidad(1)<3);
	}

}
