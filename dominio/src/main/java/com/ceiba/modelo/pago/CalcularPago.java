package com.ceiba.modelo.pago;

import java.time.LocalDateTime;

public abstract class CalcularPago extends CalcularHoras{
	private static final int MINIMAS_HORAS = 9;
	private static final int HORAS_DIA = 24;	
	
	public float calcularPago(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		int horas = horasTranscurridas(fechaIngreso, fechaSalida);

		if (horas < MINIMAS_HORAS) {
			return (getValorHoras() * horas);
		} else if (horas <= HORAS_DIA) {
			return getValorDia();
		} else {
			float pago = 0;

			int dias = (horas / HORAS_DIA);
			horas = horas % HORAS_DIA;

			if (horas < MINIMAS_HORAS) {
				pago = pago + (horas * getValorHoras());
			} else {
				pago = pago + getValorDia();
			}

			pago = pago + (dias * getValorDia());

			return pago;
		}
	}
	
	
	
	public abstract float getValorHoras();
	
	public abstract float getValorDia();
}
