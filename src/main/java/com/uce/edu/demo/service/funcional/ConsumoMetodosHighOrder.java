package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IEstudianteSupplier<String> funcion) {

		return funcion.getNombre()+"--- Se proceso el dato";
	}

	public void consumirConsumer(IEstudianteConsumer<String> funcion, String valor) {
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IEstudiantePredicate<String> funcion,String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IEstudianteFunction<String, Integer> funcion,Integer valor) {
		
		
		return funcion.aplicar(valor);
	}
	
	public String consumirUnary(IEstudianteUnaryOperator< String> funcion,String valor) {
		
		
		return funcion.apply(valor);
	}
	
	

	
}
