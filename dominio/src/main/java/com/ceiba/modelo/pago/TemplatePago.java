package com.ceiba.modelo.pago;

public final class TemplatePago {
	private static final String CODIGO_CONTENEDORES_BRAZIL = "br";
	private static final String CODIGO_CONTENEDORES_URUGUAY = "ur";
	private static final String CODIGO_CONTENEDORES_BOLIVIA = "bo";
	
	public TemplatePago() {
		
	}
	
	public static CalcularPago gestionarPago(String codigo) {
		if(validarDosPrimerasLetras(codigo)) {
			return new PagoContenedorConRestricciones();
		}else {
			return new PagoContenedorSinRestricciones();
		}
	}	
	
	private static boolean validarDosPrimerasLetras(String codigo) {
		String primerasDosLetras = codigo.toLowerCase().substring(0,2);
		return primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_BRAZIL) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_URUGUAY) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_BOLIVIA);
	}
}
