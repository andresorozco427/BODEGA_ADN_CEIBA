package com.ceiba.testdatabuilder;

import com.ceiba.modelo.Contenedor;

public class ContenedorTestBuilder {

	private String codigo;
	private String mercancia;
	private boolean perecedero;
	private String color;
	private String peso;
	
	public ContenedorTestBuilder() {
		this.codigo = "AR0102";
		this.mercancia = "tomates";
		this.perecedero = true;
		this.color = "blanco";
		this.peso = "500kg";
	}
	
	public ContenedorTestBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
		
	public ContenedorTestBuilder conMercancia(String mercancia) {
		this.mercancia = mercancia;
		return this;
	}
	
	public ContenedorTestBuilder conEsPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
		return this;
	}
	
	public ContenedorTestBuilder conColor(String color) {
		this.color = color;
		return this;
	}
	
	public ContenedorTestBuilder conPeso(String peso) {
		this.peso = peso;
		return this;			
	}
	
	public Contenedor build() {
		return new Contenedor(codigo, mercancia, perecedero, color, peso);
	}
	
	
}
