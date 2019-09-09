package com.ceiba.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.excepcion.ExcepcionHistorialYaExistente;
import com.ceiba.excepcion.ExcepcionCantidadContenedores;
import com.ceiba.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.PruebaBase;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.puerto.repositorio.RepositorioBodega;
import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.testdatabuilder.ContenedorTestBuilder;

public class ServicioEntradaContenedorTest {
	private static final String CODIGO = "AR0201";
	private static final String CODIGO_CONTENEDOR_CHILENO = "CH0201";
	private static final String CODIGO_CONTENEDOR_VENEZOLANO = "VE0201";
	private static final int LIMITE_BODEGA_PERECEDEROS = 20;
	private static final int LIMITE_BODEGA_NO_PERECEDEROS = 30;
	private static final DayOfWeek DIA_SABADO = DayOfWeek.SATURDAY;
	private static final DayOfWeek DIA_DOMINGO = DayOfWeek.SUNDAY;
	private static final String DIA_NO_HABIL = "El contenedor no puede ingresar, dia no habil";
	private static final String BODEGA_ALMACENAJE_CONTENIDO_PERECEDEROS = "Contenido perecedero";
	private static final String BODEGA_ALMACENAJE_CONTENIDO_NO_PERECEDEROS = "Contenido no perecedero";
	
	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioContenedor repositorioContenedor;
	private RepositorioBodega repositorioBodega;
	
	@Before
	public void setUp() {
		repositorioHistorialAlmacenamiento = mock(RepositorioHistorialAlmacenamiento.class);
		repositorioContenedor = mock(RepositorioContenedor.class);
		repositorioBodega = mock(RepositorioBodega.class);
	}
	
	@Test(expected = ExcepcionHistorialYaExistente.class)
	public void validarExistenciaContenedor() {
		//Arrange
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento();
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();		
		historialAlmacenamiento.setContenedor(contenedor);		
		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, 
				repositorioContenedor, repositorioBodega);
		
		historialAlmacenamiento.setFechaSalida(null);
		
		//Act
		when(repositorioHistorialAlmacenamiento.consultarHistorialAlmacenamiento(historialAlmacenamiento.getContenedor().getCodigo())).thenReturn(historialAlmacenamiento);
		
		//Assert
		servicioHistorialAlmacenamiento.ejecutar(contenedor);
		
	}
	
	
	@Test(expected = ExcepcionCantidadContenedores.class)
	public void validarDisponibilidadDeCuposEnBodegaContenedoresPerecederos() {
		//Arrange
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento();
		Contenedor contenedor = new ContenedorTestBuilder().build();
		historialAlmacenamiento.setContenedor(contenedor);		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, 
			repositorioContenedor, repositorioBodega);
		historialAlmacenamiento.setFechaSalida(null);		
		//Act
		when(repositorioHistorialAlmacenamiento.cantidadContenedores(contenedor.getPerecedero())).thenReturn(LIMITE_BODEGA_PERECEDEROS);		
		//Assert			
		servicioHistorialAlmacenamiento.ejecutar(contenedor);
		
	}
	
	@Test(expected = ExcepcionCantidadContenedores.class)
	public void validarDisponibilidadDeCuposEnBodegaContenedoresNoPerecederos() {
		//Arrange
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento();
		Contenedor contenedor = new ContenedorTestBuilder().conEsPerecedero(false).build();
		historialAlmacenamiento.setContenedor(contenedor);		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, 
			repositorioContenedor, repositorioBodega);
		historialAlmacenamiento.setFechaSalida(null);		
		//Act
		when(repositorioHistorialAlmacenamiento.cantidadContenedores(contenedor.getPerecedero())).thenReturn(LIMITE_BODEGA_NO_PERECEDEROS);		
		//Assert			
		servicioHistorialAlmacenamiento.ejecutar(contenedor);
		
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaSabadoContenedorArgentino() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_SABADO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaDomingoContenedorArgentino() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento,
		repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_DOMINGO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaSabadoContenedorChileno() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_CHILENO).build();		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_SABADO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaDomingoContenedorChileno() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_CHILENO).build();
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento,
		repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_DOMINGO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaSabadoContenedorVenezolano() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_VENEZOLANO).build();		
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_SABADO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarAutorizacionDeIngresoDelContenedorDiaDomingoContenedoVenezolano() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_VENEZOLANO).build();
		ServicioEntradaContenedor servicioHistorialAlmacenamiento = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento,
		repositorioContenedor, repositorioBodega);
		
		//Act //Assert
		PruebaBase.assertThrow(() -> servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_DOMINGO), ExcepcionDiaNoHabil.class,DIA_NO_HABIL);
	}
	
	@Test
	public void validarBodegaDeAlmacenamientoSegunContenedorConContenidoPerecedero() {
		//Arrange
		Contenedor contenedor = new ContenedorTestBuilder().conEsPerecedero(true).build();		
		ServicioEntradaContenedor servicioEntradaContenedor = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, repositorioContenedor, repositorioBodega);
		
		//Act
		BodegaAlmacenaje bodegaAlmacenaje = servicioEntradaContenedor.creacionDeBodegaSegunTipoContenidoContenedor(contenedor.getPerecedero());
		
		//Assert
		assertEquals(bodegaAlmacenaje.getTipoContenedores(), BODEGA_ALMACENAJE_CONTENIDO_PERECEDEROS);
	}
	
	@Test
	public void validarBodegaDeAlmacenamientoSegunContenedorConContenidoNoPerecedero() {
		//Arrange
		Contenedor contenedor = new ContenedorTestBuilder().conEsPerecedero(false).build();		
		ServicioEntradaContenedor servicioEntradaContenedor = new ServicioEntradaContenedor(repositorioHistorialAlmacenamiento, repositorioContenedor,repositorioBodega);
		
		//Act
		BodegaAlmacenaje bodegaAlmacenaje = servicioEntradaContenedor.creacionDeBodegaSegunTipoContenidoContenedor(contenedor.getPerecedero());
		
		//Assert
		assertEquals(bodegaAlmacenaje.getTipoContenedores(), BODEGA_ALMACENAJE_CONTENIDO_NO_PERECEDEROS);
	}
	
}
