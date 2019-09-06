package com.ceiba.modelo.bodega;

import com.ceiba.modelo.HistorialAlmacenamiento;

public abstract class BodegaAlmacenaje {
	private String codigo;
	private String nombre;
	private HistorialAlmacenamiento historialAlmacenamiento;
	private String tipoContenedores;	
	
	public BodegaAlmacenaje(String codigo, HistorialAlmacenamiento historialAlmacenamiento,
			String tipoContenedores) {
		this.codigo = codigoBodega();
		this.nombre = "Bodega ceiba s.a.s";
		this.historialAlmacenamiento = historialAlmacenamiento;
		this.tipoContenedores = tipoContenidoContenedor();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public HistorialAlmacenamiento getHistorialAlmacenamiento() {
		return historialAlmacenamiento;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setHistorialAlmacenamiento(HistorialAlmacenamiento historialAlmacenamiento) {
		this.historialAlmacenamiento = historialAlmacenamiento;
	}

	public void setTipoContenedores(String tipoContenedores) {
		this.tipoContenedores = tipoContenedores;
	}

	public String getTipoContenedores() {
		return tipoContenedores;
	}

	public String getNombre() {
		return nombre;
	}

	
	public abstract String tipoContenidoContenedor();
	
	public abstract String codigoBodega();
	
}
