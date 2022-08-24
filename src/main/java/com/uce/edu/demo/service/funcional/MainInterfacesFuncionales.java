package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		//SUPPLIER
		//Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase 2: "+supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda=() -> "Edison2";
		LOG.info("Supplier Lambdas: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE=() -> "Daniel TE2";
		LOG.info("Supplier Lambdas 2: "+supplierLambdaTE.getNombre());
		
		 //Metodos High Order
		String valorHO =metodosHO.consumirSupplier(()-> "Hola mundo");
		LOG.info("HO Supplier: "+valorHO);
		
		String valorHO1 =metodosHO.consumirSupplier(()-> {
			String valorConsultado= "1723026900";
			return valorConsultado;
		});
		LOG.info("HO Supplier 2: "+valorHO1);
		 //JAVA
		 
		 
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase= new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda= cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		 //Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
	
		
		
		//PREDICATE
		//Clases

		//Lambdas
		IPersonaPredicate<String> predicateLambda= cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambdas: "+predicateLambda.evaluar("EdiZon"));
		
		//Metodos High Order
		boolean respuesta =metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "EdiZon");
		LOG.info("HO Predicate : "+respuesta);
		//FUNCTION
		//Clases
		//Lambdas
		
		IPersonaFunction<Integer, String> functionLambda = cadena ->{ 
			
			Integer valor = Integer.parseInt(cadena);	
			Integer valorFinal = valor-2;
			return valorFinal;
		};
		LOG.info("Function Lambdas: "+functionLambda.aplicar("7"));
		
		//Metodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
		}, 1);
		LOG.info("HO Function : "+valorFinalHO);
		
		
		//UNCARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
		 IPersonaUnaryOperator<String> unaryLambda=  cade -> {
			 String valorFinal=cade.concat(" sufijo");
			 return valorFinal;
		 };
		 LOG.info("Function Lambdas: "+unaryLambda.apply("Daniel"));
		 
		
	}

}
