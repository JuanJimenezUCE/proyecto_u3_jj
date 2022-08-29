package com.uce.edu.demo.service.funcional;

public class EstudianteFunctionImpl implements IEstudianteFunction<Integer, String>{

	@Override
	public Integer aplicar(String arg1) {
		// TODO Auto-generated method stub
		Integer valor = Integer.parseInt(arg1);	
		Integer valorFinal = valor+5;
		return valorFinal;
	}

}
