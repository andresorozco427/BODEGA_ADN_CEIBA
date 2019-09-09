package com.ceiba.modelo.bodega;

//CONCRETE BUILDER
public class BodegaContenedoresNoPerecederos extends BodegaAlmacenajeBuilder{
	private static final String CODIGO = "BD002";
	private static final String TIPO_CONTENIDO_ALMACENAJE = "Contenido no perecedero";
	private static final String DIRECCION = "Cra 152 #54-34";
	private static final String TELEFONO = "4387378";
	private static final String NOMBRE = "Bodega ceiba software s.a.s NP";

	@Override
	public void buildCodigo() {
		bodegaAlmacenamiento.setCodigo(CODIGO);
	}
	
	@Override
	public void buildTipoContenidoAlamcenaje() {
		bodegaAlmacenamiento.setTipoContenedores(TIPO_CONTENIDO_ALMACENAJE);		
	}

	@Override
	public void buildNombre() {
		bodegaAlmacenamiento.setNombre(NOMBRE);
		
	}

	@Override
	public void buildDireccion() {
		bodegaAlmacenamiento.setDireccion(DIRECCION);
		
	}

	@Override
	public void buildTelefono() {
		bodegaAlmacenamiento.setTelefono(TELEFONO);
		
	}



}
