package com.ceiba.testdatabuilder;

import com.ceiba.comando.ComandoContenedor;

public class ComandoContenedorTestBuilder {
	private String codigo;
	private String mercancia;
	private boolean perecedero;
	private String color;
	private String peso;
	public ComandoContenedorTestBuilder() {
		this.codigo = "PR0909";
		this.mercancia = "Pescado";
		this.perecedero = true;
		this.color = "blanco";
		this.peso = "9T";
	}
	
	public ComandoContenedorTestBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public ComandoContenedorTestBuilder conMercancia(String mercancia) {
		this.mercancia = mercancia;
		return this;
	}
	
	public ComandoContenedorTestBuilder conEsPerecedero(boolean esPerecedero) {
		this.perecedero = esPerecedero;
		return this;
	}
	
	public ComandoContenedorTestBuilder conColor(String color) {
		this.color = color;
		return this;
	}
	
	public ComandoContenedorTestBuilder conPeso(String peso) {
		this.peso = peso;
		return this;
	}
	
	public ComandoContenedor build() {
		return new ComandoContenedor(codigo, mercancia, perecedero, color, peso);
	}
	
	

}
