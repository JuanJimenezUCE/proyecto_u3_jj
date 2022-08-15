package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uce.edu.demo.repository.modelo.ContadorHabitaciones;
import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
class HotelServiceImplTest {

	@Autowired
	private IHotelService hotelService;

	@Test
	void testBuscarHotel() {
		Hotel h2=hotelService.buscarHotel("Suite");
		assertNotNull(h2);
	}

	@Test
	void testContarHabitaciones() {
		   ContadorHabitaciones contador=this.hotelService.contarHabitaciones(3, "Familiar");
	        assertTrue(contador.getCantidad()>1);
	}

}
