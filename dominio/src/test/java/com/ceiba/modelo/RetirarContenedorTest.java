package com.ceiba.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.testdatabuilder.RetirarContenedorTestBuilder;

public class RetirarContenedorTest {
	private static final String MENSAJE_NO_HAY_CODIGO = "No se encontro el codigo";
	private static final String MENSAJE_NO_HAY_FECHAINGRESO = "No se encontro fecha de ingreso";
	private static final String MENSAJE_NO_HAY_FECHASALIDA = "No se encontro fecha de salida";
	private static final String MENSAJE_NO_GENERO_PAGO = "No se encontro fecha de ingreso";	
	
	private RetirarContenedorTestBuilder salidaHistorialAlmacenamiento;
	
	@Before
	public void setUp() {
		this.salidaHistorialAlmacenamiento = new RetirarContenedorTestBuilder();
	}
	
	@Test
	public void validarArgumentoCodigoVacioRespuestaSalida() {
		//Arrange		
		salidaHistorialAlmacenamiento.conCodigo(null);	
		//Act 
		try {
			salidaHistorialAlmacenamiento.build();
		} catch (Exception e) {
			//Assert
			assertEquals(MENSAJE_NO_HAY_CODIGO, e.getMessage());
		}	
		
	}
	
	@Test
	public void validarArgumentoFechaIngresoRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamiento.conFechaIngreso(null);
		
		//Act
		try {
			salidaHistorialAlmacenamiento.build();
		}catch (Exception e) {
			assertEquals(MENSAJE_NO_HAY_FECHAINGRESO, e.getMessage());
		}
	}
	
	
	@Test
	public void validarArgumentoFechaSalidaVaciaRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamiento.conFechaSalida(null);
		
		//Act
		try {
			salidaHistorialAlmacenamiento.build();
		}catch (Exception e) {
			assertEquals(MENSAJE_NO_HAY_FECHASALIDA, e.getMessage());
		}
	}
	
	@Test
	public void validarArgumentoPagoVacioRespuestaSalida() {
		//Arrange
		salidaHistorialAlmacenamiento.conPago(0);		
		//Act
		try {
			salidaHistorialAlmacenamiento.build();
		}catch (Exception e) {
			assertEquals(MENSAJE_NO_GENERO_PAGO, e.getMessage());
		}
	}

}
