package com.ceiba.excepcion;

public class ExcepcionContenedorNoAlmacenado extends RuntimeException{

	private static final long serialVersionUID = -4465720599333282414L;

	public ExcepcionContenedorNoAlmacenado(String message) {
		super(message);
	}
	
	

}
