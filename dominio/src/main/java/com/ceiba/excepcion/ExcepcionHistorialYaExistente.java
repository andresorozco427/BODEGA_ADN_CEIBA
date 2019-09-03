package com.ceiba.excepcion;

public class ExcepcionHistorialYaExistente extends RuntimeException{

	private static final long serialVersionUID = 8355023569417011533L;

	public ExcepcionHistorialYaExistente(String message) {
		super(message);
	}
	
	
}
