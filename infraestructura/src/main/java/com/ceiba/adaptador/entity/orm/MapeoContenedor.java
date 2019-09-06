package com.ceiba.adaptador.entity.orm;

import com.ceiba.adaptador.entity.EntityContenedor;
import com.ceiba.modelo.Contenedor;

public class MapeoContenedor {
	
	private MapeoContenedor() {
		
	}
	
	public static Contenedor convertirAModelo(EntityContenedor entitycontenedor) {
		Contenedor contenedor = null;
		
		if(entitycontenedor != null) {
			contenedor = new Contenedor(entitycontenedor.getCodigo(),
					entitycontenedor.getMercancia(), 
					entitycontenedor.getPerecedero(), 
					entitycontenedor.getColor(), 
					entitycontenedor.getPeso());
		}
		return contenedor;
	}
	
	public static EntityContenedor convertirAEntidad(Contenedor contenedor) {
		EntityContenedor entidadContenedor = null;	
		
		if(String.valueOf(contenedor) != null) {
			entidadContenedor = new EntityContenedor();
			entidadContenedor.setCodigo(contenedor.getCodigo());
			entidadContenedor.setMercancia(contenedor.getMercancia());
			entidadContenedor.setPerecedero(contenedor.getPerecedero());
			entidadContenedor.setColor(contenedor.getColor());
			entidadContenedor.setPeso(contenedor.getPeso());
		}else {
			entidadContenedor = new EntityContenedor("BR0756", "tomates", true, "balcno", "6t");
		}
		return entidadContenedor;
	}
}
