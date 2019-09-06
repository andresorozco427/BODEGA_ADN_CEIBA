package com.ceiba.modelo;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.excepcion.ExcepcionValoresEsperadosSalida;
import com.ceiba.testdatabuilder.RetirarContenedorTestBuilder;

public class RetirarContenedorTest {
	private static final String MENSAJE_NO_HAY_CODIGO = "No se encontro el codigo";
	private static final String MENSAJE_NO_HAY_FECHAINGRESO = "No se encontro fecha de ingreso";
	private static final String MENSAJE_NO_HAY_FECHASALIDA = "No se encontro fecha de salida";
	private static final String MENSAJE_NO_GENERO_PAGO = "No se encontro fecha de ingreso";	
	
	private RetirarContenedorTestBuilder salidaHistorialAlmacenamientoTestBuilder;
	
	@Before
	public void setUp() {
		this.salidaHistorialAlmacenamientoTestBuilder = new RetirarContenedorTestBuilder();
	}
	
	@Test
	public void validarArgumentoCodigoVacioRespuestaSalida() {
		//Arrange		
		salidaHistorialAlmacenamientoTestBuilder.conCodigo(null);	
		
		//Act //Assert
		PruebaBase.asserThrow(() -> salidaHistorialAlmacenamientoTestBuilder.build(), ExcepcionValoresEsperadosSalida.class, MENSAJE_NO_HAY_CODIGO);	
		
	}
	
	@Test
	public void validarArgumentoFechaIngresoRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamientoTestBuilder.conFechaIngreso(null);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> salidaHistorialAlmacenamientoTestBuilder.build(), ExcepcionValoresEsperadosSalida.class, MENSAJE_NO_HAY_FECHAINGRESO);
	}
	
	
	@Test
	public void validarArgumentoFechaSalidaVaciaRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamientoTestBuilder.conFechaSalida(null);
		
		//Act //Assert
		PruebaBase.asserThrow(() -> salidaHistorialAlmacenamientoTestBuilder.build(), ExcepcionValoresEsperadosSalida.class, MENSAJE_NO_HAY_FECHASALIDA);
	}
	
	@Test
	public void validarArgumentoPagoVacioRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamientoTestBuilder.conPago(0);		
		//Act //Assert
		PruebaBase.asserThrow(() -> salidaHistorialAlmacenamientoTestBuilder.build(), ExcepcionValoresEsperadosSalida.class, MENSAJE_NO_GENERO_PAGO);
	}

}
