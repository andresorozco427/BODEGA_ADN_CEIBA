package com.ceiba.modelo.pago;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class CalcularPago {
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
	
	private int horasTranscurridas(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		
		Duration duration = Duration.between(fechaIngreso, fechaSalida);
		long segundos = Math.abs(duration.getSeconds());
		
		int horas = (int) (segundos / 3600);
		segundos = segundos % 3600;
		int minutos = (int) (segundos / 60);

		if (minutos > 0) {
			horas++;
			return horas;
		}

		segundos = segundos % 60;

		if (segundos > 0 && horas == 0) {
			horas++;
			return horas;
		}
		return horas;
		
	}
	
	public abstract float getValorHoras();
	
	public abstract float getValorDia();
}
