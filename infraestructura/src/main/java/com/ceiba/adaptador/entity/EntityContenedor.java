package com.ceiba.adaptador.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contenedor")
public class EntityContenedor {
	
	@Id
	private String codigo;	
	private String mercancia;	
	private boolean perecedero;
	private String color;
	private String peso;
	
	public EntityContenedor() {
	}

	public EntityContenedor(String codigo, String mercancia, boolean perecedero, String color, String peso) {
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

	public boolean getPerecedero() {
		return perecedero;
	}

	public void setPerecedero(boolean perecedero) {
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
