package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase= new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda= cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		//PREDICATE
		//Clases
		//Lambdas
		
		//FUNCTION
		//Clases
		//Lambdas
		
		//UNCARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
	}

}
