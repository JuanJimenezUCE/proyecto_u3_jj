package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IEstudiantePredicate<T> {
	public boolean evaluar(T arg1);
}
