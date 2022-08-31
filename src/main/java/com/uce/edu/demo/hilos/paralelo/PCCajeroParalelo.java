package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajeroP;
	
	public PCCajeroParalelo(CajeroParalelo cajeroP) {
		this.cajeroP=cajeroP;
		
	}
	
	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajeroP);
	}

	public void procesar(CajeroParalelo cajero) {

		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre  hilo procesar:" + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;

		
		
		System.out.println("termino: "+cajero.getNombre()+" en "+tiempoTrans+" seg");
        
	
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo: a:" + cliente);
		// Demorar el metodo 5 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
