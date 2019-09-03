/**
 * 
 */
package com.ceiba.modelo;

import java.time.LocalDateTime;

/**
 * @author andres.orozco
 *
 */
public class SalidaHistorialAlmacenamiento {
	private static final String MENSAJE_NO_HAY_CODIGO = "No se encontro el codigo";
	private static final String MENSAJE_NO_HAY_FECHAINGRESO = "No se encontro fecha de ingreso";
	private static final String MENSAJE_NO_HAY_FECHASALIDA = "No se encontro fecha de salida";
	private static final String MENSAJE_NO_GENERO_PAGO = "No se encontro fecha de ingreso";	
	
	private String codigo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;
	
	public SalidaHistorialAlmacenamiento() {
		
	}
	
	public SalidaHistorialAlmacenamiento(String codigo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida,
			float pago) {
		ValidarArgumentosRetirarContenedor.validarArgumentoCodigo(codigo, MENSAJE_NO_HAY_CODIGO);
		ValidarArgumentosRetirarContenedor.validarArgumentoFechaIngreso(fechaIngreso, MENSAJE_NO_HAY_FECHAINGRESO);
		ValidarArgumentosRetirarContenedor.validarArgumentoFechaSalida(fechaSalida, MENSAJE_NO_HAY_FECHASALIDA);
		ValidarArgumentosRetirarContenedor.validarArgumentoPago(pago, MENSAJE_NO_GENERO_PAGO);
		
		this.codigo = codigo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public float getPago() {
		return pago;
	}
	public void setPago(float pago) {
		this.pago = pago;
	}
	
	
}
