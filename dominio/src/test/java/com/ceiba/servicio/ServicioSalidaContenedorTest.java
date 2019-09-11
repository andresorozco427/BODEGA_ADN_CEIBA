package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.modelo.Contenedor;
import com.ceiba.puerto.repositorio.RepositorioBodega;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.testdatabuilder.ContenedorTestBuilder;

public class ServicioSalidaContenedorTest {
	private static final String CODIGO_SIN_RESTRICCIONES = "CH3432";
	private static final String CODIGO_CON_RESTRICCIONES = "BR3432";
	
	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioBodega repositorioBodega;
	
	@Before
	public void setUp() {
		this.repositorioHistorialAlmacenamiento = mock(RepositorioHistorialAlmacenamiento.class);
		this.repositorioBodega = mock(RepositorioBodega.class);
	}

	
	@Test
	public void calcularPagoDeUnDiaContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(24);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento, repositorioBodega);
		//Act 
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 100000, 0.0001);
	}
	
	@Test
	public void calcularPagoSieteHorasContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(7);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento, repositorioBodega);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 140000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeUnDiaContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento, repositorioBodega);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 180000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeCincoHorasContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(5);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento, repositorioBodega);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 180000, 0.0001);
	}
	
	
}
