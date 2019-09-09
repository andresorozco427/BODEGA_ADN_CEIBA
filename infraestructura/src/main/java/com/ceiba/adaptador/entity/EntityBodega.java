package com.ceiba.adaptador.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class EntityBodega {
	
	@Id
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String tipoContenedores;
	
	public EntityBodega() {
	}

	public EntityBodega(String codigo, String nombre, String direccion, String telefono, String tipoContenedores) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoContenedores = tipoContenedores;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoContenedores() {
		return tipoContenedores;
	}

	public void setTipoContenedores(String tipoContenedores) {
		this.tipoContenedores = tipoContenedores;
	}	
	
	
	
}
