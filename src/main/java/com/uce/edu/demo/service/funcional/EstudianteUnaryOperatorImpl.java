package com.uce.edu.demo.service.funcional;

public class EstudianteUnaryOperatorImpl implements IEstudianteUnaryOperator<String>{

	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		
		 String valorFinal=arg1.concat("-- Jimenez");
		 return valorFinal;

	}

}
