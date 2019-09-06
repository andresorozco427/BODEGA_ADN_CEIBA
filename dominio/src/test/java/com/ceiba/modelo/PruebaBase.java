package com.ceiba.modelo;

import static org.junit.Assert.fail;

import java.util.function.Supplier;

import org.junit.Assert;


public class PruebaBase {
	
	private static final String FUE_LANZADA = "fue lanzada";
	private static final String SE_ESPERABA_LA_EXCEPCION = "Se esperaba la funcion";
	
	public static <T> void asserThrow(Supplier<T> supplier, Class<? extends Exception> exception, String mensaje) {
		try {
			supplier.get();
			fail();
		}catch (Exception e) {
			Assert.assertTrue(SE_ESPERABA_LA_EXCEPCION + exception.getCanonicalName() + FUE_LANZADA
					+e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(mensaje));
		}
	}
	
	
	public static void assertThrow(Thunk thunk, Class<? extends Exception> exception, String mensaje) {
		try {
			thunk.ejecutar();
			fail();
		}catch (Exception e) {
			Assert.assertTrue(SE_ESPERABA_LA_EXCEPCION + exception.getCanonicalName() + FUE_LANZADA
					+e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(mensaje));
		}
	}
	
	public interface Thunk{
		void ejecutar();
	}
}
