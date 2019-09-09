/**
 * 
 */
package com.ceiba.modelo;

import java.time.LocalDateTime;

import com.ceiba.modelo.bodega.BodegaAlmacenaje;

/**
 * Clase la cual representa nuestro objeto de historial de almacenamiento del contenedor
 * @author andres.orozco
 * @versionm 1.0
 *
 */
public class HistorialAlmacenamiento {

	
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private Contenedor contenedor;
	private BodegaAlmacenaje bodegaAlmacenaje;
	private float pago;		


	public HistorialAlmacenamiento() {
	}
	
	public HistorialAlmacenamiento(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, Contenedor contenedor,BodegaAlmacenaje bodegaAlmacenaje,
			float pago) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.contenedor = contenedor;
		this.bodegaAlmacenaje = bodegaAlmacenaje;
		this.pago = pago;
	}
	
	
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Contenedor getContenedor() {
		return contenedor;
	}
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
	public float getPago() {
		return pago;
	}
	public void setPago(float pago) {
		this.pago = pago;
	}

	public BodegaAlmacenaje getBodegaAlmacenaje() {
		return bodegaAlmacenaje;
	}

	public void setBodegaAlmacenaje(BodegaAlmacenaje bodegaAlmacenaje) {
		this.bodegaAlmacenaje = bodegaAlmacenaje;
	}
	
	
	
	
}
