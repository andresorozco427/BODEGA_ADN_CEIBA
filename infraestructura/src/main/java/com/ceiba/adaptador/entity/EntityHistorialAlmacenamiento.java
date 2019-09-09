package com.ceiba.adaptador.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historialAlmacenamiento")
public class EntityHistorialAlmacenamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;	
	private float pago;	
	@ManyToOne
	@JoinColumn(name = "contenedor_id", referencedColumnName = "codigo")
	private EntityContenedor contenedor;
	@ManyToOne
	@JoinColumn(name = "bodega_id", referencedColumnName = "codigo")
	private EntityBodega bodega;
	
	public EntityHistorialAlmacenamiento() {
	}
	
	public EntityHistorialAlmacenamiento(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, float pago,
			EntityContenedor contenedor, EntityBodega bodega) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		this.contenedor = contenedor;
		this.bodega = bodega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EntityContenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(EntityContenedor contenedor) {
		this.contenedor = contenedor;
	}

	public EntityBodega getBodega() {
		return bodega;
	}

	public void setBodega(EntityBodega bodega) {
		this.bodega = bodega;
	}
	
	
	
	
}
