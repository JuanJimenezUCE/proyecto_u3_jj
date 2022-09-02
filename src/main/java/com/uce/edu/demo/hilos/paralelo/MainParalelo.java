package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo : " + Thread.currentThread().getName());
		FabricaParalelo fabrica1 = new FabricaParalelo("Fabricacion telefonos motorola", Arrays.asList("Moto g1"));
		FabricaParalelo fabrica2 = new FabricaParalelo("Fabricacion telefonos sony", Arrays.asList("MArk 4"));
		FabricaParalelo fabrica3 = new FabricaParalelo("Fabricacion telefonos apple", Arrays.asList("Iphone 14"));
		
		
		FabricaParalelo fabrica4 = new FabricaParalelo("Fabricacion telefonos samsung", Arrays.asList( "S22 Ultra"));
		FabricaParalelo fabrica5 = new FabricaParalelo("Fabricacion telefonos htc", Arrays.asList( "One m9"));


		PCFabricaParalelo gestorFabricacion = new PCFabricaParalelo(fabrica1);
		gestorFabricacion.start();//procesar

		PCFabricaParalelo gestorFabricacion2 = new PCFabricaParalelo(fabrica2);
		gestorFabricacion2.start();//procesar

		PCFabricaParalelo gestorFabricacion3 = new PCFabricaParalelo(fabrica3);
		gestorFabricacion3.start();//procesar
		
		
	
		PCFabricaParalelo gestorFabricacion4 = new PCFabricaParalelo(fabrica4);
		gestorFabricacion4.start();//procesar
	
		PCFabricaParalelo gestorFabricacion5 = new PCFabricaParalelo(fabrica5);
		gestorFabricacion5.start();//procesar
	
		
	
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTrans + "seg");

	}

}
