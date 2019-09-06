package com.ceiba.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.servicio.ServicioSalidaContenedor;

@Component
public class ManejadorSalidaContenedor {
	
	private final ServicioSalidaContenedor servicioContenedorSalida;

	@Autowired
	public ManejadorSalidaContenedor(ServicioSalidaContenedor servicioContenedorSalida) {
		this.servicioContenedorSalida = servicioContenedorSalida;
	}
	
	public SalidaHistorialAlmacenamiento retirarAlmacenamientoContenedor(HistorialAlmacenamiento historial) {
		return this.servicioContenedorSalida.ejecutar(historial);
	}
	
	
}
