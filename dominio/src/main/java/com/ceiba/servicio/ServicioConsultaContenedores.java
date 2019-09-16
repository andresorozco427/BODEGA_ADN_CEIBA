package com.ceiba.servicio;

import java.util.List;

import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

public class ServicioConsultaContenedores{
	
	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;

	public ServicioConsultaContenedores(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		this.repositorioHistorialAlmacenamiento = repositorioHistorialAlmacenamiento;
	}
	
	public HistorialAlmacenamiento consultarHistorialDeAlmacenamiento(String codigo) {
		return this.repositorioHistorialAlmacenamiento.consultarContenedorAlmacenado(codigo);
	}	
	
	public List<HistorialAlmacenamiento> listarContenedoresAlmacenados(){
		return this.repositorioHistorialAlmacenamiento.consultarContenedoresAlmacenadosEnLaBodega();
	}
	
	public boolean elContenedorSeEncuentraAlmacenado(String codigo) {
		return this.repositorioHistorialAlmacenamiento.elContenedorSeEncuentraAlmacenado(codigo);
	}

	public HistorialAlmacenamiento actualizarContenedorAlmacenado(HistorialAlmacenamiento historialAlmacenamiento,
			Contenedor contenedor) {
		historialAlmacenamiento.setContenedor(contenedor);		
		
		return this.repositorioHistorialAlmacenamiento.actualizarContenedorAlmacenado(historialAlmacenamiento);
	}	
	
	
}
