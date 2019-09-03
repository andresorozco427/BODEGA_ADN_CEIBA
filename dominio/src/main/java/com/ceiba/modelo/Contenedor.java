/**
 * 
 */
package com.ceiba.modelo;

/**
 * En este modelo definimos nuestra clase contenedor, en la cual se tiene
 * en cuenta diferentes excepciones a la hora de manipularlo
 * @author andres.orozco
 * @version 1.0
 *
 */
public class Contenedor {
	private static final String MENSAJE_CODIGO_ES_OBLIGATORIO = "el codigo del contenedor es obligatorio";
	private static final String MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA = "la longitud del codigo del contenedor es incorrecta";
	private static final int LONGITUD_CODIGO = 6;
	private static final String MENSAJE_MERCANCIA_ES_OBLIGATORIA = "la mercancia del contenedor es obligatoria";
	private static final String MENSAJE_COLOR_ES_OBLIGATORIO = "el color del contenedor es obligatorio";
	private static final String MENSAJE_PESO_ES_OBLIGATORIO = "el peso del contenedor es obligatorio";
	private static final String MENSAJE_PERECEDERO_ES_OBLIGATORIO = "la confirmacion si es perecedero o no es obligatorio";
	
	private String codigo;
	private String mercancia;
	private Perecedero perecedero;
	private String color;
	private String peso;	
	
	public Contenedor(String codigo, String mercancia, Perecedero perecedero ,String color, String peso) {
		ValidarArgumentosDelContenedor.validarArgumentosCodigo(codigo, MENSAJE_CODIGO_ES_OBLIGATORIO);
		ValidarArgumentosDelContenedor.validarArgumentosLongitudCodigo(codigo, LONGITUD_CODIGO, MENSAJE_LONGITUD_DEL_CODIGO_INVALIDA);
		
		ValidarArgumentosDelContenedor.validarArgumentosTipoCarga(mercancia, MENSAJE_MERCANCIA_ES_OBLIGATORIA);
		ValidarArgumentosDelContenedor.validarArgumentosColor(color, MENSAJE_COLOR_ES_OBLIGATORIO);
		ValidarArgumentosDelContenedor.validarArgumentoPeso(peso, MENSAJE_PESO_ES_OBLIGATORIO);
		ValidarArgumentosDelContenedor.validarArgumentosEsPerecedero(perecedero, MENSAJE_PERECEDERO_ES_OBLIGATORIO);
		
		this.codigo = codigo;
		this.mercancia = mercancia;
		this.perecedero = perecedero;
		this.color = color;
		this.peso = peso;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMercancia() {
		return mercancia;
	}
	public void setMercancia(String tipoCarga) {
		this.mercancia = tipoCarga;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public Perecedero getPerecedero() {
		return perecedero;
	}


	public void setPerecedero(Perecedero perecedero) {
		this.perecedero = perecedero;
	}
	
	
	
}
