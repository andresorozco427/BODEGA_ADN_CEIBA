package com.ceiba.adaptador.entity.orm;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.adaptador.entity.EntityHistorialAlmacenamiento;
import com.ceiba.modelo.HistorialAlmacenamiento;

public final class MapeoHistorialAlmacenamiento {
	
	private MapeoHistorialAlmacenamiento() {
		
	}
	
	public static HistorialAlmacenamiento convertirAModelo(EntityHistorialAlmacenamiento entityHistorialAlmacenamiento) {
		HistorialAlmacenamiento historialAlmacenamiento = null;
		
		if(entityHistorialAlmacenamiento != null) {
			historialAlmacenamiento = new HistorialAlmacenamiento(entityHistorialAlmacenamiento.getFechaIngreso(), entityHistorialAlmacenamiento.getFechaSalida(),
					MapeoContenedor.convertirAModelo(entityHistorialAlmacenamiento.getContenedor()), MapeoBodega.convertirAModelo(entityHistorialAlmacenamiento.getBodega()), 
					entityHistorialAlmacenamiento.getPago());
		}
		return historialAlmacenamiento;
	}	
	
	public static EntityHistorialAlmacenamiento convertirAEntidad(HistorialAlmacenamiento historialAlmacenamiento) {
		EntityHistorialAlmacenamiento entityHistorialAlmacenamiento = null;
		
		if(historialAlmacenamiento != null) {
			entityHistorialAlmacenamiento = new EntityHistorialAlmacenamiento();
			entityHistorialAlmacenamiento.setFechaIngreso(historialAlmacenamiento.getFechaIngreso());
			entityHistorialAlmacenamiento.setFechaSalida(historialAlmacenamiento.getFechaSalida());
			entityHistorialAlmacenamiento.setPago(historialAlmacenamiento.getPago());
			entityHistorialAlmacenamiento.setBodega(MapeoBodega.convertirAEntidad(historialAlmacenamiento.getBodegaAlmacenaje()));
			entityHistorialAlmacenamiento.setContenedor(MapeoContenedor.convertirAEntidad(historialAlmacenamiento.getContenedor()));
		}
		return entityHistorialAlmacenamiento;
	}
	
	public static List<HistorialAlmacenamiento> convertirAModelo(Iterable<EntityHistorialAlmacenamiento> listaContenedores){
		List<HistorialAlmacenamiento> contenedoresAlmacenados = new ArrayList<>();
		for (EntityHistorialAlmacenamiento historialAlmacenamiento : listaContenedores) {
			contenedoresAlmacenados.add(convertirAModelo(historialAlmacenamiento));
		}
		return contenedoresAlmacenados;
	}
}
