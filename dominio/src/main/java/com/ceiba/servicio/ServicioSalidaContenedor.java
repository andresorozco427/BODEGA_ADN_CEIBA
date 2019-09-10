package com.ceiba.servicio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.modelo.bodega.BodegaAlmacenajeDirector;
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
			fechaSalida = LocalDateTime.now().plusSeconds(1);
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

	public HistorialAlmacenamiento consultarEstadiaContenedorPerecedero(Iterable<HistorialAlmacenamiento> listaContenedoresAlmacenados) {
		HistorialAlmacenamiento historial = null;
		for (HistorialAlmacenamiento historialAlmacenamiento : listaContenedoresAlmacenados) {
			if(cantidadDeHorasEnBodega(historialAlmacenamiento.getFechaIngreso()) > HORAS_DIA) {
				BodegaAlmacenajeDirector director = new  BodegaAlmacenajeDirector();
				director.setBodegaBuilder(new BodegaContenedoresPerecederosCaducados());
				director.construirBodega();				
				BodegaAlmacenaje bodegaAlmacenaje = director.obtenerBodegaAlmacenaje();
				historialAlmacenamiento.setBodegaAlmacenaje(bodegaAlmacenaje);
				historial = historialAlmacenamiento;
				
				this.repositorioHistorialAlmacenamiento.actualizarHistorialAlmacenamiento(historialAlmacenamiento);
				
			}
		}
		return historial;
	}
	
	private int cantidadDeHorasEnBodega(LocalDateTime fechaIngreso) {
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

	@Override
	public void run() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		List<HistorialAlmacenamiento> historialAlmacenamientos = this.repositorioHistorialAlmacenamiento.consultarContenedoresAlmacenadosEnLaBodega();
		scheduledExecutorService.schedule((Runnable) consultarEstadiaContenedorPerecedero(historialAlmacenamientos), 1, TimeUnit.SECONDS);
	}
}
