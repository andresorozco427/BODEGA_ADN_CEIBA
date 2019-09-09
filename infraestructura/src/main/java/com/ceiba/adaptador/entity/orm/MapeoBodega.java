package com.ceiba.adaptador.entity.orm;

import com.ceiba.adaptador.entity.EntityBodega;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;

public class MapeoBodega {
	
	public static BodegaAlmacenaje convertirAModelo(EntityBodega entityBodega) {
		BodegaAlmacenaje bodegaAlmacenaje = null;
		
		if(entityBodega != null) {
			bodegaAlmacenaje = new BodegaAlmacenaje(entityBodega.getCodigo(),
					entityBodega.getNombre(),
					entityBodega.getDireccion(), 		
					entityBodega.getTelefono(), 
					entityBodega.getTipoContenedores());
		}
		return bodegaAlmacenaje;
	}
	
	public static EntityBodega convertirAEntidad(BodegaAlmacenaje bodegaAlmacenaje) {
		EntityBodega entityBodega = null;
		
		if(bodegaAlmacenaje != null) {
			entityBodega = new EntityBodega();
			entityBodega.setCodigo(bodegaAlmacenaje.getCodigo());
			entityBodega.setDireccion(bodegaAlmacenaje.getDireccion());
			entityBodega.setNombre(bodegaAlmacenaje.getNombre());
			entityBodega.setTelefono(bodegaAlmacenaje.getTelefono());
			entityBodega.setTipoContenedores(bodegaAlmacenaje.getTipoContenedores());
		}
		return entityBodega;
	}
}
