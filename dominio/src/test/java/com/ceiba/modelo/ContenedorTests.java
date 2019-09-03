package com.ceiba.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ceiba.testdatabuilder.ContenedorTestBuilder;


public class ContenedorTests {
	private static final String CODIGO = "AR0403A";
	private static final String MENSAJE_CODIGO_ES_OBLIGATORIO = "el codigo del contenedor es obligatorio";
	private static final String MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA = "la longitud del codigo del contenedor es incorrecta";
	private static final String MENSAJE_MERCANCIA_ES_OBLIGATORIA = "la mercancia del contenedor es obligatoria";
	private static final String MENSAJE_COLOR_ES_OBLIGATORIO = "el color del contenedor es obligatorio";
	private static final String MENSAJE_PESO_ES_OBLIGATORIO = "el peso del contenedor es obligatorio";
	private static final String MENSAJE_PERECEDERO_ES_OBLIGATORIO = "la confirmacion si es perecedero o no es obligatorio";

	@Test
	public void validarArgumentosCodigoVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conCodigo(null);
		//Act
		try {	
			contenedorTestBuilder.build();
			fail();
		
		}catch (Exception e) {
		//Assert
			assertEquals(MENSAJE_CODIGO_ES_OBLIGATORIO, e.getMessage());
		}
		
	}
	
	@Test
	public void validarArgumentosLongitudCodigoModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conCodigo(CODIGO);
		
		//Act
		try {
			contenedorTestBuilder.build();
		}catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA, e.getMessage());
		}
	}
	
	@Test
	public void validarArgumentosMercanciaEsVaciaModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conMercancia(null);
		
		//Act
		try {
			contenedorTestBuilder.build();
		} catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_MERCANCIA_ES_OBLIGATORIA, e.getMessage());
		}
	}
	
	
	@Test
	public void validarArgumentosEsPerecederoEsVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conEsPerecedero(null);
		
		//Act
		try {
			contenedorTestBuilder.build();
		} catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_PERECEDERO_ES_OBLIGATORIO, e.getMessage());
		}
	}
	
	@Test
	public void validarArgumentosColorVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conColor(null);
		
		//Act
		try {
			contenedorTestBuilder.build();
		} catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_COLOR_ES_OBLIGATORIO, e.getMessage());
		}
	}
	@Test
	public void validarArgumentosPesoVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conPeso(null);
		
		//Act
		try {
			contenedorTestBuilder.build();
		} catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_PESO_ES_OBLIGATORIO, e.getMessage());
		}
	}

}
