package com.ceiba.modelo.bodega;

public class BodegaBuilder {	
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String tipoContenedores;	
	
	public BodegaBuilder() {
		
	}

	public BodegaBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public BodegaBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public BodegaBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public BodegaBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public BodegaBuilder conTipoContenidoContenedor(String tipoContenedores) {
		this.tipoContenedores = tipoContenedores;
		return this;
	}
	
	public BodegaAlmacenaje build() {
		return new BodegaAlmacenaje(codigo, nombre, direccion, telefono, tipoContenedores);
	}
}
