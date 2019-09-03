package com.ceiba.modelo;

public enum Perecedero {
	SI("si"), NO("no");
	
	private final String code;

	Perecedero(String code) {
		this.code = code;
	}
	
	public static boolean fromCode(String code) {
		if("si".equals(code) || "SI".equals(code)) {
			return true;
		}
		
		if("no".equals(code) || "NO".equals(code)) {
			return false;
		}
		
		throw new UnsupportedOperationException("El codigo" + code + "no es soportado");
	}
	
	public String getCode() {
		return code;
	}
}
