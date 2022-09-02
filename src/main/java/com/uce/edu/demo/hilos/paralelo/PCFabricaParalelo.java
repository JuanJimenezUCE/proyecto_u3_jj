package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCFabricaParalelo extends Thread {

	private FabricaParalelo fabrica;

	public PCFabricaParalelo(FabricaParalelo fabrica) {
	
		this.fabrica=fabrica;
	}
	
	public void run() {
		this.procesar(this.fabrica);
	}

	public void procesar(FabricaParalelo fabrica) {

		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre  hilo procesar:" + Thread.currentThread().getName());
		System.out.println("Procesando fabricador: " + fabrica.getNombre());
		for (String producto : fabrica.getProductos()) {
			this.fabricarProducto(producto);
		}
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;

		
		
		System.out.println("termino: "+fabrica.getNombre()+" en "+tiempoTrans+" seg");
        
	
	}

	private void fabricarProducto(String producto) {
		System.out.println("Fabricando:" + producto);
		// Demorar el metodo 5 seg
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
