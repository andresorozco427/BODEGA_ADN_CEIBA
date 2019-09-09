package com.ceiba.modelo.bodega;

public class BodegaContenedoresPerecederosCaducados extends BodegaAlmacenajeBuilder{
	private static final String CODIGO = "BD003";
	private static final String TIPO_CONTENIDO_ALMACENAJE = "Contenido perecedero caducado";
	private static final String DIRECCION = "Cra 152 #55-34";
	private static final String TELEFONO = "4387379";
	private static final String NOMBRE = "Bodega ceiba software s.a.s PC";

	@Override
	public void buildCodigo() {
		bodegaAlmacenamiento.setCodigo(CODIGO);
	}
	
	@Override
	public void buildTipoContenidoAlamcenaje() {
		bodegaAlmacenamiento.setTipoContenedores(TIPO_CONTENIDO_ALMACENAJE);		
	}

	@Override
	public void buildDireccion() {
		bodegaAlmacenamiento.setDireccion(DIRECCION);
		
	}

	@Override
	public void buildTelefono() {
		bodegaAlmacenamiento.setTelefono(TELEFONO);
	}

	@Override
	public void buildNombre() {
		bodegaAlmacenamiento.setNombre(NOMBRE);
		
	}
}
