package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaDetalleRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;
@Service
public class GestionFacturaServiceImpl implements IGestionFacturaService {

	
	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;
	
	@Autowired
	private IFacturaService iFacturaService;
	
	
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void generarFactura(String cedulaCliente, String numeroFactura, List<String> codigosBarras) {
		// TODO Auto-generated method stub
		
	
		BigDecimal totalPagar = this.iFacturaService.procesarFactura(cedulaCliente, numeroFactura, codigosBarras);

	
		this.iFacturaElectronicaService.procesarFactElectronica(numeroFactura, codigosBarras.size(), totalPagar);
		
	}

}
