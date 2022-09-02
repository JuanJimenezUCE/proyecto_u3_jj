package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);



	
	public static void guardar(String elementoAInsertar){
		LOG.info("Impresion: " +elementoAInsertar);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		// SUPPLIER
	
		// JAVA

		LOG.info("Supplier JAVA");
	
		Stream<String> test = Stream.generate(() -> "Implementacion Supplier").limit(4);
		test.forEach(cade -> System.out.println(cade));

		// CONSUMER
		
		// JAVA
		LOG.info("Java  Consumer");
		List<Integer> listaNum= Arrays.asList(10, 8, 6,4, 2,0);
		listaNum.forEach(numero -> System.out.println("Lista decendente "+numero));

		// PREDICATE
	
		// JAVA

		LOG.info("Java  Predicate");
		Stream<Integer> lista = listaNum.stream().filter(numero -> numero < 5);
		lista.forEach(numero -> System.out.println("Filtro "+numero));

		// FUNCTION
		
		// JAVA
		LOG.info("Java  Function");

		Stream<String> lista2 = listaNum.stream().map(numeros -> {
			Integer valor = numeros + 1;
			String cadena = "Numero Impares Decendentes: " + valor.toString();
			return cadena;
		});
	
	
		lista2.forEach(valor -> guardar(valor));
	
		

	}

}
