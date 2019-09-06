package com.ceiba.modelo;

import com.ceiba.excepcion.ExcepcionValoresEsperadosSalida;

public final class ValidarArgumentosRetirarContenedor{	
	
	private ValidarArgumentosRetirarContenedor() {
	}

	public static void validarArgumentoCodigo(Object codigo, String mensaje) {
		if(codigo == null) {
			throw new ExcepcionValoresEsperadosSalida(mensaje);
		}
	}
	
	public static void validarArgumentoFechaIngreso(Object fechaIngreso, String mensaje) {
		if(fechaIngreso == null) {
			throw new ExcepcionValoresEsperadosSalida(mensaje);
		}
	}
	
	public static void validarArgumentoFechaSalida(Object fechaSalida, String mensaje) {
		if(fechaSalida == null) {
			throw new ExcepcionValoresEsperadosSalida(mensaje);
		}
	}
	
	public static void validarArgumentoPago(float pago, String mensaje) {
		if(pago == 0) {
			throw new ExcepcionValoresEsperadosSalida(mensaje);
		}
	}
	

}
