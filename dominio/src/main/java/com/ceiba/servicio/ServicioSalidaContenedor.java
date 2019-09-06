package com.ceiba.servicio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.modelo.bodega.BodegaContenedoresPerecederosCaducados;
import com.ceiba.modelo.pago.TemplatePago;
import com.ceiba.modelo.pago.CalcularPago;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

public class ServicioSalidaContenedor implements Runnable{
	private static final int HORAS_DIA = 24;

	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;

	public ServicioSalidaContenedor(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		this.repositorioHistorialAlmacenamiento = repositorioHistorialAlmacenamiento;
	}
	
	public SalidaHistorialAlmacenamiento ejecutar(HistorialAlmacenamiento historial) {
		LocalDateTime fechaSalida = historial.getFechaSalida();
		if(fechaSalida == null) {
			fechaSalida = LocalDateTime.now();
		}
		float valorDelPago = calcularPagoSegunContenedor(historial.getFechaIngreso(), fechaSalida, historial.getContenedor().getCodigo());
		historial.setFechaSalida(fechaSalida);
		historial.setPago(valorDelPago);
		
		return this.repositorioHistorialAlmacenamiento.actualizarHistorialAlmacenamiento(historial);
	}

	public float calcularPagoSegunContenedor(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String codigo) {
		CalcularPago shapePago = TemplatePago.gestionarPago(codigo);
		return shapePago.calcularPago(fechaIngreso, fechaSalida);
	}

	public Runnable consultarEstadiaContenedorPerecedero(Iterable<HistorialAlmacenamiento> listaContenedoresAlmacenados) {
		for (HistorialAlmacenamiento historialAlmacenamiento : listaContenedoresAlmacenados) {
			if(cantidadDeHorasEnBodega(historialAlmacenamiento.getFechaIngreso()) > HORAS_DIA) {
				BodegaAlmacenaje bodegaAlmacenaje = new BodegaContenedoresPerecederosCaducados("", historialAlmacenamiento, "");
				this.repositorioHistorialAlmacenamiento.almacenarHistorialEnBodega(bodegaAlmacenaje);
			}
		}
		return null;
	}
	
	private int cantidadDeHorasEnBodega(LocalDateTime fechaIngreso) {
		LocalDateTime fechaActual = LocalDateTime.now();
		long divisorParaConvertirAsegundos = 1000;
		long segundos = (fechaActual.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli()
				- fechaIngreso.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli()) / divisorParaConvertirAsegundos;		
		
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

	@Override
	public void run() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		List<HistorialAlmacenamiento> historialAlmacenamientos = this.repositorioHistorialAlmacenamiento.consultarContenedoresAlmacenadosEnLaBodega();
		scheduledExecutorService.schedule(consultarEstadiaContenedorPerecedero(historialAlmacenamientos), 1, TimeUnit.SECONDS);
	}
}
