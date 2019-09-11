package com.ceiba.modelo.bodega;

public class BodegaAlmacenaje {
	
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String tipoContenedores;	
	
	public BodegaAlmacenaje(String codigo, String nombre, String direccion, String telefono, String tipoContenedores) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoContenedores = tipoContenedores;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getTipoContenedores() {
		return tipoContenedores;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setTipoContenedores(String tipoContenedores) {
		this.tipoContenedores = tipoContenedores;
	}
	
	
}
