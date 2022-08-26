package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	@Override
	@Transactional(value= TxType.REQUIRES_NEW)
	public void procesarFactElectronica(String numFactura, Integer nItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica fElectronica =new FacturaElectronica();
		fElectronica.setNumero(numFactura);
		fElectronica.setMonto(monto);
		fElectronica.setFechaCreacion(LocalDateTime.now());
		fElectronica.setNumeroItems(nItems);
		this.electronicaRepository.insertar(fElectronica);
		throw new RuntimeException();
	}

}
