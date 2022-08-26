package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	
	public void procesarFactElectronica(String numFactura, Integer nItems, BigDecimal monto);

}
