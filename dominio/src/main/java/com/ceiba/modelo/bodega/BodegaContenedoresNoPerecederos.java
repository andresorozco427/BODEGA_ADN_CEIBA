package com.ceiba.modelo.bodega;

import com.ceiba.modelo.HistorialAlmacenamiento;

public class BodegaContenedoresNoPerecederos extends BodegaAlmacenaje{
	private static final String TIPO_CONTENEDORES = "Contenedor no perecedero";
	private static final String CODIGO = "BD001";
	
	public BodegaContenedoresNoPerecederos(String codigo, HistorialAlmacenamiento historialAlmacenamiento,
			String tipoContenedores) {
		super(codigo, historialAlmacenamiento, tipoContenedores);
	}

	@Override
	public String tipoContenidoContenedor() {
		return TIPO_CONTENEDORES;
	}

	@Override
	public String codigoBodega() {
		return CODIGO;
	}

	

}
