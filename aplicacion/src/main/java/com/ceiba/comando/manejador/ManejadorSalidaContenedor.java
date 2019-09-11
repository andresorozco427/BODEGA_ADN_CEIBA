package com.ceiba.comando.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.excepcion.ExcepcionContenedorNoAlmacenado;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.servicio.ServicioConsultaContenedores;
import com.ceiba.servicio.ServicioSalidaContenedor;

@Component
public class ManejadorSalidaContenedor {
	private static final String ERROR_CONTENEDOR_NO_SE_ENCUENTRA_ALMACENADO = "El contenedor no se encuentra almacenado en la bodega";
	
	private final ServicioSalidaContenedor servicioContenedorSalida;
	private final ServicioConsultaContenedores servicioConsultaContenedores;

	@Autowired
	public ManejadorSalidaContenedor(ServicioSalidaContenedor servicioContenedorSalida, ServicioConsultaContenedores servicioConsultaContenedores) {
		this.servicioContenedorSalida = servicioContenedorSalida;
		this.servicioConsultaContenedores = servicioConsultaContenedores;
	}
	
	public void consultaHistorialAlmacenamientoContenedoresPerecederos(List<HistorialAlmacenamiento> listaContenedores) {
		 this.servicioContenedorSalida.consultarEstadiaContenedorPerecedero(listaContenedores);
	}
	
	public boolean elcontenedorSeEncuentraAlmacenado(String codigo) {
		return this.servicioConsultaContenedores.elContenedorSeEncuentraAlmacenado(codigo);
	}
	
	public SalidaHistorialAlmacenamiento retirarAlmacenamientoContenedor(HistorialAlmacenamiento historial) {
		String codigo = historial.getContenedor().getCodigo();
		
		if(elcontenedorSeEncuentraAlmacenado(codigo)) {
			 throw new ExcepcionContenedorNoAlmacenado(ERROR_CONTENEDOR_NO_SE_ENCUENTRA_ALMACENADO);
		}
		
		return this.servicioContenedorSalida.ejecutar(historial);
	}
	
	
}
