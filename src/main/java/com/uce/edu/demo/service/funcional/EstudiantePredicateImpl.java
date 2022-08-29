package com.uce.edu.demo.service.funcional;

public class EstudiantePredicateImpl implements IEstudiantePredicate<String>{

	@Override
	public boolean evaluar(String arg1) {

		return arg1.contains("J");
	}


}
