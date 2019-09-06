package com.ceiba.modelo.bodega;

import com.ceiba.modelo.HistorialAlmacenamiento;

public class BodegaContenedoresPerecederosCaducados extends BodegaAlmacenaje{
	private static final String TIPO_CONTENEDORES = "Contenedor perecedero caducados";
	private static final String CODIGO = "BD003";

	public BodegaContenedoresPerecederosCaducados(String codigo, HistorialAlmacenamiento historialAlmacenamiento,
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
