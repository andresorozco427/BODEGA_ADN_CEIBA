package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.SalidaHistorialAlmacenamiento;

public class RetirarContenedorTestBuilder {
	
	private String codigo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private float pago;
	
	public RetirarContenedorTestBuilder() {
		this.codigo = "EC8767";
		this.fechaIngreso = LocalDateTime.now();
		this.fechaSalida = LocalDateTime.now().plusHours(7);
		this.pago = 0;
	}
	
	public RetirarContenedorTestBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public RetirarContenedorTestBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public RetirarContenedorTestBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public RetirarContenedorTestBuilder conPago(float pago) {
		this.pago = pago;
		return this;
	}
	
	public SalidaHistorialAlmacenamiento build() {
		return new SalidaHistorialAlmacenamiento(codigo, fechaIngreso, fechaSalida, pago);
	}
	
}
