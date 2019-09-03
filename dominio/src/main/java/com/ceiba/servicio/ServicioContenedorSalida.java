package com.ceiba.servicio;

import java.time.LocalDateTime;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.modelo.pago.TemplatePago;
import com.ceiba.modelo.pago.Pago;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

public class ServicioContenedorSalida {

	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;

	public ServicioContenedorSalida(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		this.repositorioHistorialAlmacenamiento = repositorioHistorialAlmacenamiento;
	}
	
	public SalidaHistorialAlmacenamiento ejecutarSalidaContenedor(HistorialAlmacenamiento historial) {
		LocalDateTime fechaSalida = historial.getFechaSalida();
		if(fechaSalida == null) {
			//fechaSalida = LocalDateTime.now();
		}
		float valorDelPago = calcularPagoSegunContenedor(historial.getFechaIngreso(), fechaSalida, historial.getContenedor().getCodigo());
		historial.setFechaSalida(fechaSalida);
		historial.setPago(valorDelPago);
		
		return this.repositorioHistorialAlmacenamiento.actualizarHistorialAlmacenamiento(historial);
	}

	public float calcularPagoSegunContenedor(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String codigo) {
		Pago shapePago = TemplatePago.gestionarPago(codigo);
		return shapePago.calcularPago(fechaIngreso, fechaSalida);
	}
}
