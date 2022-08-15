package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;

public interface IFacturaRepository {

	

	//CRUD
	public Factura consultar(Integer id);
	public void create(Factura f);
	public void update(Factura f);
	public void delete(Integer id);
	
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaInnerJoin();
	
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);
	
	public List<Factura> buscarFacturaOuterJoinLeft( );

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);
	
}
