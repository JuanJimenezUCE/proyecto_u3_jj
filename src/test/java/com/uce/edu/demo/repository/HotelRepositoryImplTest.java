package com.uce.edu.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.modelo.Hotel;
@SpringBootTest
class HotelRepositoryImplTest {

	
	@Autowired
	private IHotelRepository hotelRepository;
	//Test 2
	@Test
	void testBuscarHotel() {
		Hotel h=new Hotel();
		h.setId(6);
		//Prueba completada
		h.setDireccion("Barcelona");
		//Prueba fallida
		//h.setDireccion("Francia");

		assertEquals(h.getDireccion(), this.hotelRepository.buscarHotel("Suite").getDireccion());
	}

}
