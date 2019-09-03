package com.ceiba.adaptador.entity.orm;

import com.ceiba.adaptador.entity.EntityContenedor;
import com.ceiba.modelo.Contenedor;

public class MapeoContenedor {
	
	private MapeoContenedor() {
		
	}
	
	public static Contenedor convertirAModelo(EntityContenedor Entitycontenedor) {
		Contenedor contenedor = null;
		
		if(Entitycontenedor != null) {
			contenedor = new Contenedor(Entitycontenedor.getCodigo(),
					Entitycontenedor.getMercancia(), 
					Entitycontenedor.getPerecedero(), 
					Entitycontenedor.getColor(), 
					Entitycontenedor.getPeso());
		}
		return contenedor;
	}
	
	public static EntityContenedor convertirAEntidad(Contenedor contenedor) {
		EntityContenedor entidadContenedor = null;
		
		if(contenedor != null) {
			entidadContenedor = new EntityContenedor();
			entidadContenedor.setCodigo(contenedor.getCodigo());
			entidadContenedor.setMercancia(contenedor.getMercancia());
			entidadContenedor.setPerecedero(contenedor.getPerecedero());
			entidadContenedor.setColor(contenedor.getColor());
			entidadContenedor.setPeso(contenedor.getPeso());
		}
		return entidadContenedor;
	}
}
