package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaSeriveImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void realizarTransferencia(String numerotaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//0.Busque la cta Origen (obetener saldo)
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero(numerotaOrigen);
		
		//1. Restar el monto a la cuenta origen
		
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal); 
		this.bancariaRepository.actualizar(ctaOrigen);
		//0.Busque la cta Origen (obetener saldo)
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero(numeroCtaDestino);
		
		//2. Sumar el monto a la cta origen
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		//3. Insertar trasnferencia
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCtaOrigen(ctaOrigen);
		trans.setCtaDestino(ctaDestino);
		this.transferenciaRepository.insertar(trans);
		//commit
	}
	@Override
	@Transactional(value =TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

}
