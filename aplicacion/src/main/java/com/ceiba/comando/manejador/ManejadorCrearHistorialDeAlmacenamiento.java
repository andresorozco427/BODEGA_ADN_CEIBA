package com.ceiba.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoContenedor;
import com.ceiba.modelo.Contenedor;
import com.ceiba.servicio.ServicioEntradaContenedor;

@Component
public class ManejadorCrearHistorialDeAlmacenamiento {	
	
	private ServicioEntradaContenedor servicioHistorialAlmacenamiento;

	@Autowired
	public ManejadorCrearHistorialDeAlmacenamiento(ServicioEntradaContenedor servicioHistorialAlmacenamiento) {
		this.servicioHistorialAlmacenamiento = servicioHistorialAlmacenamiento;
	}
	
	public void ejecutar(ComandoContenedor comandoContenedor) {
		Contenedor contenedor = new Contenedor(comandoContenedor.getCodigo(), comandoContenedor.getMercancia(), comandoContenedor.getPerecedero()
				, comandoContenedor.getColor(),  comandoContenedor.getPeso());
		
		this.servicioHistorialAlmacenamiento.ejecutar(contenedor);
	}	

}
