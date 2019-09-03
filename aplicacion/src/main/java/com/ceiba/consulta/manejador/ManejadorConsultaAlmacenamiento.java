package com.ceiba.consulta.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.servicio.ServicioConsultaContenedores;

@Component
public class ManejadorConsultaAlmacenamiento {

	private final ServicioConsultaContenedores servicioConsultaContenedores;

	@Autowired
	public ManejadorConsultaAlmacenamiento(ServicioConsultaContenedores servicioConsultaContenedores) {
		this.servicioConsultaContenedores = servicioConsultaContenedores;
	}
	
	public List<HistorialAlmacenamiento> ListarContenedoresAlmacenados(){
		return this.servicioConsultaContenedores.listarContenedoresAlmacenados();
	}
	
	public HistorialAlmacenamiento consultarHistorialAlmacenamiento(String codigo) {
		return this.consultarHistorialAlmacenamiento(codigo);
	}
	
	
}
