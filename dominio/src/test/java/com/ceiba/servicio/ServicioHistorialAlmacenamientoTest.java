package com.ceiba.servicio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import com.ceiba.modelo.Perecedero;
import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;
import com.ceiba.testdatabuilder.ContenedorTestBuilder;

public class ServicioHistorialAlmacenamientoTest {
	private static final String CODIGO = "AR0201";
	private static final String CODIGO_CONTENEDOR_CHILENO = "CH0201";
	private static final String CODIGO_CONTENEDOR_VENEZOLANO = "VE0201";
	private static final int MAXIMO_CUPOS_BODEGA = 30;
	private static final DayOfWeek DIA_SABADO = DayOfWeek.SATURDAY;
	private static final DayOfWeek DIA_DOMINGO = DayOfWeek.SUNDAY;
	
	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioContenedor repositorioContenedor;
	
	@Before
	public void setUp() {
		repositorioHistorialAlmacenamiento = mock(RepositorioHistorialAlmacenamiento.class);
		repositorioContenedor = mock(RepositorioContenedor.class);
	}
	
	@Test(expected = ExcepcionHistorialYaExistente.class)
	public void validarExistenciaContenedor() {
		//Arrange
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento();
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();		
		historialAlmacenamiento.setContenedor(contenedor);		
		
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, 
				repositorioContenedor);
		
		historialAlmacenamiento.setFechaSalida(null);
		
		//Act
		when(repositorioHistorialAlmacenamiento.consultarHistorialAlmacenamiento(historialAlmacenamiento.getContenedor().getCodigo())).thenReturn(historialAlmacenamiento);
		
		//Assert
		servicioHistorialAlmacenamiento.ejecutarAlmacenamientoContenedor(contenedor);
		
	}
	
	
	@Test(expected = ExcepcionCantidadContenedores.class)
	public void validarDisponibilidadDeCuposEnBodega() {
		//Arrange
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento();
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();
		historialAlmacenamiento.setContenedor(contenedor);
		
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, 
			repositorioContenedor);
		historialAlmacenamiento.setFechaSalida(null);
		
		//Act
		when(repositorioHistorialAlmacenamiento.cantidadContenedores(contenedor)).thenReturn(MAXIMO_CUPOS_BODEGA);
		
		//Assert
			
		servicioHistorialAlmacenamiento.ejecutarAlmacenamientoContenedor(contenedor);
		
	}
	
	@Test(expected = ExcepcionDiaNoHabil.class)
	public void validarAutorizacionDeIngresoDelContenedorDiaSabado() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();		
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, repositorioContenedor);
		
		//Assert
		servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_SABADO);
	}
	
	@Test(expected = ExcepcionDiaNoHabil.class)
	public void validarAutorizacionDeIngresoDelContenedorDiaDomingo() {
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento,
		repositorioContenedor);
		
		//Assert 
		servicioHistorialAlmacenamiento.validarCodigoParaDiasHabiles(contenedor.getCodigo(), DIA_DOMINGO);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void validarEsPerecederoInvalido() {
		Perecedero.fromCode("Invalid");
	}
	
	@Test 
	public void esPerecedero() {
		Boolean esPerecedero = Perecedero.fromCode("si");
		assertTrue(esPerecedero);
	}
	
	@Test
	public void noEsPerecedero() {
		Boolean noEsPerecedero = Perecedero.fromCode("no");
		assertFalse(noEsPerecedero);
	}
	
	@Test
	public void validarSiContenedorEsProvenienteDeArgentina() {
		//Arrange
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO).build();
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, repositorioContenedor);
		
		//Act 
		Boolean ContenedorArgentino = servicioHistorialAlmacenamiento.validarDosPrimerasLetras(contenedor.getCodigo());
		//Assert
		assertTrue(ContenedorArgentino);
	}
	@Test
	public void validarSiContenedorEsProvenienteDeChile() {
		//Arrange
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_CHILENO).build();
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, repositorioContenedor);
		
		//Act 
		Boolean ContenedorChileno = servicioHistorialAlmacenamiento.validarDosPrimerasLetras(contenedor.getCodigo());
		//Assert
		assertTrue(ContenedorChileno);
	}
	
	@Test
	public void validarSiContenedorEsProvenienteDeVenezuela() {
		//Arrange
		Contenedor contenedor = new ContenedorTestBuilder().conCodigo(CODIGO_CONTENEDOR_VENEZOLANO).build();
		ServicioHistorialAlmacenamiento servicioHistorialAlmacenamiento = new ServicioHistorialAlmacenamiento(repositorioHistorialAlmacenamiento, repositorioContenedor);
		
		//Act 
		Boolean ContenedorVenezolano = servicioHistorialAlmacenamiento.validarDosPrimerasLetras(contenedor.getCodigo());
		//Assert
		assertTrue(ContenedorVenezolano);
	}
	
}
