package com.ceiba.modelo.bodega;

//CONCRETE BUILDER
public class BodegaContenedoresPerecederos extends BodegaAlmacenajeBuilder{

	@Override
	public void buildCodigo() {
		bodegaAlmacenamiento.setCodigo("BD001");
	}
	
	@Override
	public void buildTipoContenidoAlamcenaje() {
		bodegaAlmacenamiento.setTipoContenedores("Contenido perecedero");		
	}

	@Override
	public void buildNombre() {
		bodegaAlmacenamiento.setNombre("Bodega ceiba software s.a.s Perecederos");
		
	}

	@Override
	public void buildDireccion() {
		bodegaAlmacenamiento.setDireccion("Cra 151 #54-34");
		
	}

	@Override
	public void buildTelefono() {
		bodegaAlmacenamiento.setTelefono("4387678");
		
	}



}
