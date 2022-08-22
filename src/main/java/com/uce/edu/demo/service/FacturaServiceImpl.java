package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
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

}
