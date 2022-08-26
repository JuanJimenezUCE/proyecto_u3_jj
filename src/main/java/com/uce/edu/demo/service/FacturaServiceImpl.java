package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;
@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
	

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.buscarFacturaJoinFetch(cantidad);
	}
	
	
	//CRUD
	@Override
	public Factura consultar(Integer id) {
		return this.iFacturaRepository.consultar(id);
	}
	
	@Override
	public void create(Factura f) {
		this.iFacturaRepository.create(f);
	}

	@Override
	public void update(Factura f) {
		this.iFacturaRepository.update(f);
	}

	@Override
	public void delete(Integer id) {
		this.iFacturaRepository.delete(id);
	}
	
	//----------------Trabajo Grupal ----------------------------------
	@Override
	public BigDecimal calcularPrecio(Integer id) {
		Factura f=this.iFacturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		BigDecimal valorFactura=new BigDecimal(0);
		
		for(Detalle p: productos) {
			BigDecimal cantidad=new BigDecimal(p.getCantidad());
			//BigDecimal totalProducto=p.getPrecio().multiply(cantidad);
			//valorFactura=valorFactura.add(totalProducto);
		}
		
		return valorFactura;
		
	}

	@Override
	public int cantidad(Integer id) {
		Factura f=this.iFacturaRepository.consultar(id);
		List<Detalle> productos=f.getDetalles();
		int canasta=0;
		
		for(Detalle p: productos) {
			canasta=canasta+p.getCantidad();
		}
		
		return canasta;
	}

	@Override
	@Transactional(value =TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigosBarras) {
		// TODO Auto-generated method stub
		
		Factura factura = new Factura();
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		
		Cliente cliente= this.iClienteRepository.buscarPorCedula(cedulaCliente);
		
		factura.setCliente(cliente);
			
		this.iFacturaRepository.create(factura);
		
		
		BigDecimal total=new BigDecimal(0);
		
		List<Detalle> detalles =new ArrayList<>();
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
		    detalles.add(detalle);
		    //this.iFacturaDetalleRepository.insertar(detalle);
		
		}
		factura.setDetalles(detalles);
		
		
		return total;
	}

	
	
	
}
