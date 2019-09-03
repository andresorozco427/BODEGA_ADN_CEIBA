package com.ceiba.comando;

import com.ceiba.modelo.Perecedero;

public class ComandoContenedor {
	
	private String codigo;
	private String mercancia;
	private Perecedero perecedero;
	private String color;
	private String peso;
	
	private ComandoContenedor() {
	}

	private ComandoContenedor(String codigo, String mercancia, Perecedero perecedero, String color, String peso) {
		this.codigo = codigo;
		this.mercancia = mercancia;
		this.perecedero = perecedero;
		this.color = color;
		this.peso = peso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMercancia() {
		return mercancia;
	}

	public void setMercancia(String mercancia) {
		this.mercancia = mercancia;
	}

	public Perecedero getPerecedero() {
		return perecedero;
	}

	public void setPerecedero(Perecedero perecedero) {
		this.perecedero = perecedero;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}	
	
	
	
}
