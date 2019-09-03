package com.ceiba.adaptador.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historialAlmacenamiento")
public class EntityHistorialAlmacenamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fecha_ingreso")
	private LocalDateTime fechaIngreso;
	@Column(name = "fecha_salida")
	private LocalDateTime fechaSalida;	
	private float pago;	
	@OneToOne
	@JoinColumn(name = "codigo", referencedColumnName = "codigo")
	private EntityContenedor contenedor;
	
	public EntityHistorialAlmacenamiento() {
	}
	
	public EntityHistorialAlmacenamiento(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, float pago,
			EntityContenedor contenedor) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		this.contenedor = contenedor;
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
	
	
	
	
	
}
