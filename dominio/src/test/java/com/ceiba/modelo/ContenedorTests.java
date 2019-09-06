package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.excepcion.ExcepcionLongitudCodigo;
import com.ceiba.excepcion.ExceptionValoresObligatorios;
import com.ceiba.testdatabuilder.ContenedorTestBuilder;


public class ContenedorTests {
	private static final String CODIGO = "AR0403A";
	private static final String MENSAJE_CODIGO_ES_OBLIGATORIO = "el codigo del contenedor es obligatorio";
	private static final String MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA = "la longitud del codigo del contenedor es incorrecta";
	private static final String MENSAJE_MERCANCIA_ES_OBLIGATORIA = "la mercancia del contenedor es obligatoria";
	private static final String MENSAJE_COLOR_ES_OBLIGATORIO = "el color del contenedor es obligatorio";
	private static final String MENSAJE_PESO_ES_OBLIGATORIO = "el peso del contenedor es obligatorio";

	@Test
	public void validarArgumentosCodigoVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conCodigo(null);
		//Act //Assert
		PruebaBase.asserThrow(() -> contenedorTestBuilder.build(), ExceptionValoresObligatorios.class,MENSAJE_CODIGO_ES_OBLIGATORIO);
		
	}
	
	@Test
	public void validarArgumentosLongitudCodigoModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conCodigo(CODIGO);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> contenedorTestBuilder.build(), ExcepcionLongitudCodigo.class,MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA);
	}
	
	@Test
	public void validarArgumentosMercanciaEsVaciaModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conMercancia(null);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> contenedorTestBuilder.build(), ExceptionValoresObligatorios.class,MENSAJE_MERCANCIA_ES_OBLIGATORIA);
	}
	
	@Test
	public void validarArgumentosColorVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conColor(null);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> contenedorTestBuilder.build(), ExceptionValoresObligatorios.class, MENSAJE_COLOR_ES_OBLIGATORIO);
	}
	@Test
	public void validarArgumentosPesoVacioModeloContenedor() {
		//Arrange
		ContenedorTestBuilder contenedorTestBuilder = new ContenedorTestBuilder().conPeso(null);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> contenedorTestBuilder.build(), ExceptionValoresObligatorios.class, MENSAJE_PESO_ES_OBLIGATORIO);
	}

}
