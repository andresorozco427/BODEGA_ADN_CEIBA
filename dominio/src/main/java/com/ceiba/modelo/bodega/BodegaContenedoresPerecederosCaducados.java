package com.ceiba.modelo.bodega;

public class BodegaContenedoresPerecederosCaducados extends BodegaAlmacenajeBuilder{
	@Override
	public void buildCodigo() {
		bodegaAlmacenamiento.setCodigo("BD003");
	}
	
	@Override
	public void buildTipoContenidoAlamcenaje() {
		bodegaAlmacenamiento.setTipoContenedores("Contenido perecedero caducado");		
	}

	@Override
	public void buildDireccion() {
		bodegaAlmacenamiento.setDireccion("Cra 152 #55-34");
		
	}

	@Override
	public void buildTelefono() {
		bodegaAlmacenamiento.setTelefono("4387379");
	}

	@Override
	public void buildNombre() {
		bodegaAlmacenamiento.setNombre("Bodega ceiba software s.a.s Perecedero Caducados");
		
	}
}
