package com.ceiba.modelo.pago;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class CalcularHoras {
	
	public int horasTranscurridas(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {		
		long divisorParaConvertirAsegundos = 1000;
		long segundos = (fechaSalida.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli()
				- fechaIngreso.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli())
				/ divisorParaConvertirAsegundos;
		
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
	
	public int cantidadDeHorasEnBodega(LocalDateTime fechaIngreso) {
		LocalDateTime fechaActual = LocalDateTime.now();
		Duration duration = Duration.between(fechaActual, fechaIngreso);
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
}
