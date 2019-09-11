package com.ceiba.modelo.bodega;

public interface BodegaAlmacenajeDirector {		
	
	public static BodegaAlmacenaje crear(boolean perecedero) {
		if(perecedero) {
			return new BodegaBuilder().conCodigo("BD001").conDireccion("Cra 141 #54-64").conNombre("Ceiba Software S.A.S Pere").conTelefono("4333234")
					.conTipoContenidoContenedor("Contenedores Perecederos").build();
		}else{
			return new BodegaBuilder().conCodigo("BD002").conDireccion("Cra 142 #54-64").conNombre("Ceiba Software S.A.S No Pere").conTelefono("4133234")
					.conTipoContenidoContenedor("Contenedores No Perecederos").build();
		}
	}
	

}
