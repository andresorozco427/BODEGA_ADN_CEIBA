package com.ceiba.modelo.bodega;


public class BodegaAlmacenajeDirector {
	
	private BodegaAlmacenajeBuilder bodegaAlmacenajeBuilder;
	
	
	public void setBodegaBuilder(BodegaAlmacenajeBuilder bodegAlmacenajeBuilder) {
		bodegaAlmacenajeBuilder = bodegAlmacenajeBuilder;
	}
	
	public BodegaAlmacenaje obtenerBodegaAlmacenaje() {
		return bodegaAlmacenajeBuilder.obtenerBodega();
	}
	
	public void construirBodega() {
		bodegaAlmacenajeBuilder.crearBodegaAlmacenamiento();
		bodegaAlmacenajeBuilder.buildCodigo();
		bodegaAlmacenajeBuilder.buildTipoContenidoAlamcenaje();
		bodegaAlmacenajeBuilder.buildNombre();
		bodegaAlmacenajeBuilder.buildDireccion();
		bodegaAlmacenajeBuilder.buildTelefono();
		
		
	}
}
