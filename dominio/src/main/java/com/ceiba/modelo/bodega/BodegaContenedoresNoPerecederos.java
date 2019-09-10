package com.ceiba.modelo.bodega;

//CONCRETE BUILDER
public class BodegaContenedoresNoPerecederos extends BodegaAlmacenajeBuilder{
	@Override
	public void buildCodigo() {
		bodegaAlmacenamiento.setCodigo("");
	}
	
	@Override
	public void buildTipoContenidoAlamcenaje() {
		bodegaAlmacenamiento.setTipoContenedores("Contenido no perecedero");		
	}

	@Override
	public void buildNombre() {
		bodegaAlmacenamiento.setNombre("Bodega Ceiba Software S.A.S No Perecederos");
		
	}

	@Override
	public void buildDireccion() {
		bodegaAlmacenamiento.setDireccion("Cra 152 #54-34");
		
	}

	@Override
	public void buildTelefono() {
		bodegaAlmacenamiento.setTelefono("4387378");
		
	}



}
