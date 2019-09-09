package com.ceiba.adaptador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioBodega;
import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.servicio.ServicioConsultaContenedores;
import com.ceiba.servicio.ServicioSalidaContenedor;
import com.ceiba.servicio.ServicioEntradaContenedor;

@Configuration
public class ServicioBean {
	
	@Autowired
	RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	@Autowired
	RepositorioContenedor repositorioContenedor;		
	@Autowired
	RepositorioBodega repositorioBodega;

	@Bean
	public ServicioConsultaContenedores servicioConsultarHistorialAlmacenamiento(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		return new ServicioConsultaContenedores(this.repositorioHistorialAlmacenamiento);
	}
	
	@Bean
	public ServicioSalidaContenedor servicioSalidaContenedor(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		return new ServicioSalidaContenedor(this.repositorioHistorialAlmacenamiento);
	}
	
	@Bean
	public ServicioEntradaContenedor servicioAgregarHistorialAlmacenamiento(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento,
			RepositorioContenedor repositorioContenedor, RepositorioBodega repositorioBodega) {
		return new ServicioEntradaContenedor(this.repositorioHistorialAlmacenamiento, this.repositorioContenedor, this.repositorioBodega);
	}
	
}
