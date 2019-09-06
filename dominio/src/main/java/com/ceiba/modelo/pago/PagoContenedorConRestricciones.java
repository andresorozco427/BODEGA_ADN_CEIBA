package com.ceiba.modelo.pago;

import java.time.LocalDateTime;

public class PagoContenedorConRestricciones extends CalcularPago{

	private static final int VALOR_HORA_CONTENEDOR = 20000;
	private static final int VALOR_DIA_CONTENEDOR = 100000;
	private static final float VALOR_AGREGADO_CONTENEDOR = 80000;
	
	@Override
	public float calcularPago(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		float pago =  super.calcularPago(fechaIngreso, fechaSalida);
		return pago + VALOR_AGREGADO_CONTENEDOR;
	}
	
	@Override
	public float getValorHoras() {
		return VALOR_HORA_CONTENEDOR;
	}
	@Override
	public float getValorDia() {
		return VALOR_DIA_CONTENEDOR;
	}

	
}
