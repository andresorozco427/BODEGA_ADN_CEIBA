package com.ceiba.modelo.bodega;

//ABSTARCT BUILDER
public abstract class BodegaAlmacenajeBuilder{
	
	protected BodegaAlmacenaje bodegaAlmacenamiento;
	
	public BodegaAlmacenaje obtenerBodega() {
		return bodegaAlmacenamiento;
	}
	
	public void crearBodegaAlmacenamiento() {
		this.bodegaAlmacenamiento = new BodegaAlmacenaje();
	}	
	public abstract void buildCodigo();
	public abstract void buildTipoContenidoAlamcenaje();
	public abstract void buildNombre();
	public abstract void buildDireccion();
	public abstract void buildTelefono();
		
}
