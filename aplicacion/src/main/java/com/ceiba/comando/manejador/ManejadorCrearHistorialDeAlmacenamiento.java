package com.ceiba.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoContenedor;
import com.ceiba.modelo.Contenedor;
import com.ceiba.servicio.ServicioHistorialAlmacenamiento;

@Component
public class ManejadorCrearHistorialDeAlmacenamiento {
	
	private final ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento;

	@Autowired
	public ManejadorCrearHistorialDeAlmacenamiento(ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento) {
		this.servicioHistorialAlmacenamiento = servicioHistorialAlmacenamiento;
	}
	
	public void ejecutarAlmacenamiento(ComandoContenedor comandoContenedor) {
		this.servicioHistorialAlmacenamiento.ejecutarAlmacenamientoContenedor(new Contenedor(comandoContenedor.getCodigo(), comandoContenedor.getMercancia(),
		comandoContenedor.getPerecedero(), comandoContenedor.getColor(), comandoContenedor.getPeso()));
	}
	

}
