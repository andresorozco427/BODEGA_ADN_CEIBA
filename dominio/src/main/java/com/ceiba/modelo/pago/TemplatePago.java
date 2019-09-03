package com.ceiba.modelo.pago;

public class TemplatePago {
	private static final String CODIGO_CONTENEDORES_BRAZIL = "br";
	private static final String CODIGO_CONTENEDORES_URUGUAY = "llllll";
	private static final String CODIGO_CONTENEDORES_BOLIVIA = "bo";
	
	private TemplatePago() {
		
	}
	
	public static Pago gestionarPago(String codigo) {
		if(validarDosPrimerasLetras(codigo)) {
			return new PagoContenedorConValorAgregado();
		}else {
			return new PagoContenedor();
		}
	}	
	private static boolean validarDosPrimerasLetras(String codigo) {
		String primerasDosLetras = codigo.toLowerCase().substring(0,2);
		return primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_BRAZIL) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_URUGUAY) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_BOLIVIA);
	}
}
