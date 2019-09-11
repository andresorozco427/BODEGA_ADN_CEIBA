package com.ceiba.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.modelo.pago.TemplatePago;
import com.ceiba.modelo.pago.CalcularHoras;
import com.ceiba.modelo.pago.CalcularPago;
import com.ceiba.puerto.repositorio.RepositorioBodega;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

public class ServicioSalidaContenedor extends CalcularHoras{
	private static final int HORAS_DIA = 24;

	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioBodega repositorioBodega;

	public ServicioSalidaContenedor(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento, RepositorioBodega repositorioBodega) {
		this.repositorioBodega = repositorioBodega;
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

	public void consultarEstadiaContenedorPerecedero(List<HistorialAlmacenamiento> listaContenedoresAlmacenados) {
		List<HistorialAlmacenamiento> listaContenedores = listaContenedoresAlmacenados.stream().filter(h -> h.getContenedor().getPerecedero() && h.getBodegaAlmacenaje().getCodigo().contentEquals("BD001")).collect(Collectors.toList());
		for (HistorialAlmacenamiento historialAlmacenamiento : listaContenedores) {
			if(cantidadDeHorasEnBodega(historialAlmacenamiento.getFechaIngreso()) >= HORAS_DIA) {
				BodegaAlmacenaje bodegaAlmacenaje = new BodegaAlmacenaje("BD003", "Cra 142 #55-64", "Ceiba Software S.A.S Perecederos Caducados", "4133234", "Contenedores Perecederos Caducados");
				historialAlmacenamiento.setBodegaAlmacenaje(bodegaAlmacenaje);	
				this.repositorioBodega.crear(bodegaAlmacenaje);
				this.repositorioHistorialAlmacenamiento.actualizarCambioDeBodegaContenedorPerecederoCaducado(historialAlmacenamiento);		
			}
		}
	}
}
