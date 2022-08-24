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
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IFacturaDetalleRepository iFacturaDetalleRepository;
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void generarFactura(String cedulaCliente, String numeroFactura, List<String> codigosBarras) {
		// TODO Auto-generated method stub
		
		Factura factura = new Factura();
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		
		Cliente cliente= this.iClienteRepository.buscarPorCedula(cedulaCliente);
		
		factura.setCliente(cliente);
			
		this.iFacturaRepository.create(factura);
		
		
		BigDecimal total=new BigDecimal(0);
		
		
		for(String p: codigosBarras) {
			
			Producto producto= this.iProductoRepository.buscarPorCodigo(p);
			producto.setStock(producto.getStock()-1);
			this.iProductoRepository.actualizar(producto);
			if(producto.getStock()<0) {
				throw new RuntimeException();
			}
		
			total= producto.getPrecio().add(total);
			
			Detalle detalle =new Detalle();
			
			detalle.setCantidad(1);
			detalle.setProducto(producto);
			detalle.setFactura(factura);
		    detalle.setSubtotal(producto.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
		    //this.iFacturaDetalleRepository.insertar(detalle);
		
		}
		

		FacturaElectronica fElectronica =new FacturaElectronica();
		fElectronica.setNumero(numeroFactura);
		fElectronica.setMonto(total);
		fElectronica.setFechaCreacion(LocalDateTime.now());
		fElectronica.setNumeroItems(codigosBarras.size());
		this.iFacturaElectronicaRepository.insertar(fElectronica);
		
		
	}

}
