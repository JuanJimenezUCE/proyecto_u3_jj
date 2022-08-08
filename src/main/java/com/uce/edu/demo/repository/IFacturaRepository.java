package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;

public interface IFacturaRepository {

	
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaInnerJoin();
	
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);
	
	public List<Factura> buscarFacturaOuterJoinLeft( );

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);
	
}
