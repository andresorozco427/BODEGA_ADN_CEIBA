package com.ceiba.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.servicio.ServicioContenedorSalida;

@Component
public class ManejadorSalidaContenedor {
	
	private final ServicioContenedorSalida servicioContenedorSalida;

	@Autowired
	public ManejadorSalidaContenedor(ServicioContenedorSalida servicioContenedorSalida) {
		this.servicioContenedorSalida = servicioContenedorSalida;
	}
	
	public SalidaHistorialAlmacenamiento retirarAlmacenamientoContenedor(HistorialAlmacenamiento historial) {
		return this.servicioContenedorSalida.ejecutarSalidaContenedor(historial);
	}
	
	
}
