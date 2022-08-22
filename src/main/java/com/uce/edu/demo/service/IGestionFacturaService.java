package com.uce.edu.demo.service;

import java.util.List;

public interface IGestionFacturaService {
	

	public void generarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras);
	
}
