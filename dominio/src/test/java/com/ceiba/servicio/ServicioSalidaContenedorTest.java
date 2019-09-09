package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.modelo.bodega.BodegaAlmacenajeDirector;
import com.ceiba.modelo.bodega.BodegaContenedoresPerecederos;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.testdatabuilder.ContenedorTestBuilder;

public class ServicioSalidaContenedorTest {
	private static final String CODIGO_SIN_RESTRICCIONES = "CH3432";
	private static final String CODIGO_CON_RESTRICCIONES = "BR3432";
	
	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	
	@Before
	public void setUp() {
		this.repositorioHistorialAlmacenamiento = mock(RepositorioHistorialAlmacenamiento.class);
	}
	
	@Test
	public void validarPaisesConValorAgregado() {
		
	}
	
	@Test
	public void calcularPagoDeUnDiaContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(24);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act 
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 100000, 0.0001);
	}
	
	@Test
	public void calcularPagoUnDiayCuatroHorasContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1).plusHours(4);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 180000, 0.0001);
	}
	
	@Test
	public void calcularPagoSieteHorasContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(7);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 140000, 0.0001);
	}
	
	@Test
	public void calcularPagoTresDiasContenedorSinRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(3);
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_SIN_RESTRICCIONES).build();
		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 300000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeUnDiaContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 180000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeUnDiaySeisHorasContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1).plusHours(6);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 300000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeCincoHorasContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusHours(5);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 180000, 0.0001);
	}
	
	@Test
	public void calcularPagoDeTresDiasContenedorConRestricciones() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(3);		
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CON_RESTRICCIONES).build();		
		ServicioSalidaContenedor servicioContenedorSalida = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		float valorTotalAPagar = servicioContenedorSalida.calcularPagoSegunContenedor(fechaIngreso, fechaSalida, contenedor.getCodigo());
		//Assert
		assertEquals(valorTotalAPagar, 380000, 0.0001);
	}
	
	@Test
	public void validarCambioDeBodegaContenedorPerecedero() {
		//Arrange
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1).minusMinutes(4);
		Contenedor contenedor = new ContenedorTestBuilder().conEsPerecedero(true).build();
		
		BodegaAlmacenajeDirector director = new BodegaAlmacenajeDirector();
		director.setBodegaBuilder(new BodegaContenedoresPerecederos());
		director.construirBodega();
		BodegaAlmacenaje bodegaAlmacenaje = director.obtenerBodegaAlmacenaje();	
		
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento(fechaIngreso, fechaSalida, contenedor, bodegaAlmacenaje, 0);
		
		List<HistorialAlmacenamiento> historial = new ArrayList<>();
		
		historial.add(historialAlmacenamiento);
		
		ServicioSalidaContenedor servicioSalidaContenedor = new ServicioSalidaContenedor(repositorioHistorialAlmacenamiento);
		//Act
		when(servicioSalidaContenedor.consultarEstadiaContenedorPerecedero(historial)).thenReturn(historialAlmacenamiento);
	}
	
	
}
