package com.ceiba.modelo.bodega;

import com.ceiba.modelo.HistorialAlmacenamiento;

public interface BodegaAlmacenajeFactory {
	
	public static BodegaAlmacenaje crear(HistorialAlmacenamiento historialAlmacenamiento) {
		boolean elContenedorEsPerecedero = historialAlmacenamiento.getContenedor().getPerecedero();
		if(elContenedorEsPerecedero) {
			return new BodegaContenedoresPerecederos("", historialAlmacenamiento, "");
		}
		else if(elContenedorEsPerecedero) {
			return new BodegaContenedoresNoPerecederos("", historialAlmacenamiento, "");
		}else {
			return null;
		}
	}
}
