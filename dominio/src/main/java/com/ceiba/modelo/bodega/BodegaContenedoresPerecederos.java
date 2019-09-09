package com.ceiba.modelo.bodega;

//CONCRETE BUILDER
public class BodegaContenedoresPerecederos extends BodegaAlmacenajeBuilder{
	private static final String CODIGO = "BD001";
	private static final String TIPO_CONTENIDO_ALMACENAJE = "Contenido perecedero";
	private static final String DIRECCION = "Cra 151 #54-34";
	private static final String TELEFONO = "4387678";
	private static final String NOMBRE = "Bodega ceiba software s.a.s P";

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
