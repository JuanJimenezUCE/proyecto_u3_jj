package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		
		LOG.info("Supplier");
		//SUPPLIER
		//Interfaz
		IEstudianteSupplier<String> supplier = new EstudianteSupplierImpl();
		LOG.info("Supplier Interfaz: "+supplier.getNombre());
		//Lambdas
		IEstudianteSupplier<String> supplierLambda=() -> "Implementacion Supplier";
		LOG.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		 //Metodos High Order
		String valorHO =metodosHO.consumirSupplier(()-> {
			String valorConsultado= "1723026900";
			return valorConsultado;
		});
		LOG.info("HO Supplier : "+valorHO);
	
		//CONSUMER	
		LOG.info("Consumer");
		//Interfaz
		IEstudianteConsumer<String> consumerClase= new EstudianteConsumerImpl();
		consumerClase.accept("Interfaz Consumer");
		
		//Lambdas
		IEstudianteConsumer<String> consumerLambda= cadena -> System.out.println(cadena);
		consumerLambda.accept("Implementacion Consumer Lambda");
		
		 //Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), "HO Consumer");
	
	
		//PREDICATE
		LOG.info("Predicate");
		//Interfaz
		IEstudiantePredicate<String> predicate= new EstudiantePredicateImpl();
		LOG.info("Predicate Interfaz: "+predicate.evaluar("Juan"));
	
		
		//Lambdas
		IEstudiantePredicate<String> predicateLambda= cadena -> cadena.contains("J");
		LOG.info("Predicate Lambdas: "+predicateLambda.evaluar("Juan"));
		
		//Metodos High Order
		boolean respuesta =metodosHO.consumirPredicate(cadena -> cadena.contains("J"), "Juan");
		LOG.info("HO Predicate : "+respuesta);
		//FUNCTION
		LOG.info("\nFunction");
		//Interfaz
		
		IEstudianteFunction<Integer, String> function = new EstudianteFunctionImpl();
		LOG.info("Function Interfaz: "+function.aplicar("6"));
		
		//Lambdas
		
		IEstudianteFunction<Integer, String> functionLambda = cadena ->{ 
			
			Integer valor = Integer.parseInt(cadena);	
			Integer valorFinal = valor+5;
			return valorFinal;
		};
		LOG.info("Function Lambda: "+functionLambda.aplicar("7"));
		
		//Metodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"-- Implementacion Function";
			return retorno;
		},4 );
		LOG.info("HO Function : "+valorFinalHO);
		
		
		//UNCARY OPERATOR 
		LOG.info("Unary Operator");
		//Interfaz
		IEstudianteUnaryOperator<String> unary = new EstudianteUnaryOperatorImpl();
		LOG.info("Unary Operator Interfaz: "+unary.apply("J"));	
		
		
		//Lambdas
		IEstudianteUnaryOperator<String> unaryLambda=  cade -> {
			 String valorFinal=cade.concat("-- Jimenez");
			 return valorFinal;
		 };
		 LOG.info("Unary Lambda: "+unaryLambda.apply("Juan"));
		 //Metodos High Order
		 
		 String valorFinalUHO = metodosHO.consumirUnary(cade-> {
			 String valorF =cade.concat("--J");
			 return valorF;
			 
		 }, "Juan ");
		 LOG.info("HO Unary Operator : "+valorFinalUHO);		 
			 
		
		 
	}

}
