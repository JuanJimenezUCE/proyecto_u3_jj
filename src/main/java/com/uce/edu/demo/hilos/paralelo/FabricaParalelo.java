package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class FabricaParalelo {

	private String nombre;
	
	private List<String> productos;

	public FabricaParalelo(String nombre, List<String> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}

	//SET Y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getProductos() {
		return productos;
	}

	public void setProductos(List<String> productos) {
		this.productos = productos;
	}
	
	
	
}
