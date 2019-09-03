package com.ceiba.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.servicio.ServicioConsultaContenedores;
import com.ceiba.servicio.ServicioContenedorSalida;
import com.ceiba.servicio.ServicioHistorialAlmacenamiento;

@Configuration
public class ServicioBean {
	
	RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	RepositorioContenedor repositorioContenedor;
	
	@Bean
	public ServicioHistorialAlmacenamiento servicioCrearHistorialAlmacenamiento(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento,
			RepositorioContenedor repositorioContenedor) {
		return new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, repositorioContenedor);
	}
	
	@Bean
	public ServicioConsultaContenedores servicioConsultarHistorialAlmacenamiento(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		return new ServicioConsultaContenedores(repositorioHistorialAlmacenamiento);
	}
	
	@Bean
	public ServicioContenedorSalida servicioSalidaContenedor(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento) {
		return new ServicioContenedorSalida(repositorioHistorialAlmacenamiento);
	}
	
}
