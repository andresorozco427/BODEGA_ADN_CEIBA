package com.ceiba.modelo;

import com.ceiba.excepcion.ExceptionValoresObligatorios;
import com.ceiba.excepcion.ExpceptionLongitudCodigo;

public final class ValidarArgumentosDelContenedor {
	
		private ValidarArgumentosDelContenedor() {
			super();
		}

		public static void validarArgumentosCodigo(Object codigo, String mensaje) {
			if(codigo == null) {
				throw new ExceptionValoresObligatorios(mensaje);
			}
		}
		
		public static void validarArgumentosLongitudCodigo(String codigo, int longitud, String mensaje) {
			if(codigo.length() != longitud) {
				throw new ExpceptionLongitudCodigo(mensaje);
			}
		}
		
		public static void validarArgumentosTipoCarga(Object mercancia, String mensaje) {
			if(mercancia == null) {
				throw new ExceptionValoresObligatorios(mensaje);
			}
		}
		
		public static void validarArgumentosEsPerecedero(Object perecedero, String mensaje) {
			if(perecedero == null) {
				throw new ExceptionValoresObligatorios(mensaje);
			}
		}
		
		public static void validarArgumentoPeso(Object peso, String mensaje) {
			if(peso == null) {
				throw new ExceptionValoresObligatorios(mensaje);
			}
		}
		
		public static void validarArgumentosColor(Object color, String mensaje) {
			if(color == null) {
				throw new ExceptionValoresObligatorios(mensaje);
			}
		}
}
