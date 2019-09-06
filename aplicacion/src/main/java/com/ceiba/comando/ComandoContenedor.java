package com.ceiba.comando;


public class ComandoContenedor {
	
	private String codigo;
	private String mercancia;
	private boolean perecedero;
	private String color;
	private String peso;
	
	public ComandoContenedor() {
		
	}
	
	public ComandoContenedor(String codigo, String mercancia, boolean perecedero, String color, String peso) {
		this.codigo = codigo;
		this.mercancia = mercancia;
		this.perecedero = perecedero;
		this.color = color;
		this.peso = peso;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getMercancia() {
		return mercancia;
	}

	public boolean getPerecedero() {
		return perecedero;
	}

	public String getColor() {
		return color;
	}

	public String getPeso() {
		return peso;
	} 	 
	
	
	
}
