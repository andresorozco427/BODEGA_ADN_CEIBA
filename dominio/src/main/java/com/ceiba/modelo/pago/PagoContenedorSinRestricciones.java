package com.ceiba.modelo.pago;

public class PagoContenedorSinRestricciones extends CalcularPago{
	
	private static final float VALOR_HORA_CONTENEDOR = 20000;
	private static final float VALOR_DIA_CONTENEDOR = 100000;
	
	
	@Override
	public float getValorHoras() {
		return VALOR_HORA_CONTENEDOR;
	}
	@Override
	public float getValorDia() {
		return VALOR_DIA_CONTENEDOR;
	}


}
