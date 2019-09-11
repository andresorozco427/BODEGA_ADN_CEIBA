	/**
 * 
 */
package com.ceiba.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.ceiba.excepcion.ExcepcionCantidadContenedores;
import com.ceiba.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.excepcion.ExcepcionHistorialYaExistente;
import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.modelo.bodega.BodegaAlmacenajeDirector;
import com.ceiba.puerto.repositorio.RepositorioBodega;
import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

/**
 * @author andres.orozco
 *
 */
public class ServicioEntradaContenedor{
	private static final String MENSAJE_HISTORIALALMACENAMIENTO_YA_EXISTENTE = "El contenedor actualmente esta almacenado en la bodega";
	private static final String MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES_NO_PERECEDEROS = "No hay cupos disponibles para mas contenedores no perecederos";
	private static final String MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES_PERECEDEROS = "No hay cupos disponibles para mas contenedores perecederos";
	private static final String MENSAJE_DIA_NO_HABIL_PARA_ALMACENAMIENTO = "El contenedor no puede ingresar, dia no habil";
	private static final int LIMITE_BODEGA_PERECEDEROS = 20;
	private static final int LIMITE_BODEGA_NO_PERECEDEROS = 30;
	private static final String CODIGO_CONTENEDORES_ARGENTINA = "ar";
	private static final String CODIGO_CONTENEDORES_CHILE = "ch";
	private static final String CODIGO_CONTENEDORES_VENEZUELA = "ve";

	private  RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioContenedor repositorioContenedor;
	private RepositorioBodega repositorioBodega;
	
	public ServicioEntradaContenedor(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento,
			RepositorioContenedor repositorioContenedor, RepositorioBodega repositorioBodega) {
		this.repositorioHistorialAlmacenamiento = repositorioHistorialAlmacenamiento;
		this.repositorioContenedor = repositorioContenedor;
		this.repositorioBodega = repositorioBodega;
	}
	
	public void ejecutar(Contenedor contenedor) {
		int totalCobrar = 0;
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = null;		
		BodegaAlmacenaje bodegaAlmacenaje = creacionDeBodegaSegunTipoContenidoContenedor(contenedor.getPerecedero());
		
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento(fechaIngreso, fechaSalida, contenedor,bodegaAlmacenaje, totalCobrar);
	
		validarContenedorAlmacenado(contenedor.getCodigo());
		validarCupos(historialAlmacenamiento);
		validarCodigoParaDiasHabiles(contenedor.getCodigo(), fechaIngreso.getDayOfWeek());		
		
		this.repositorioBodega.crear(bodegaAlmacenaje);
		this.repositorioContenedor.crear(contenedor);
		this.repositorioHistorialAlmacenamiento.crearHistorial(historialAlmacenamiento);
	}
	
	public BodegaAlmacenaje creacionDeBodegaSegunTipoContenidoContenedor(boolean perecedero) {		
		return BodegaAlmacenajeDirector.crear(perecedero);
	}

	public void validarCodigoParaDiasHabiles(String codigo, DayOfWeek dayOfWeek) {
		if(validarDosPrimerasLetras(codigo) && hoyEsSabadoODomingo(dayOfWeek)) {
			throw new ExcepcionDiaNoHabil(MENSAJE_DIA_NO_HABIL_PARA_ALMACENAMIENTO);
		}
	}

	public boolean validarDosPrimerasLetras(String codigo) {
		String primerasDosLetras = codigo.toLowerCase().substring(0,2);
		return primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_ARGENTINA) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_CHILE) || primerasDosLetras.contentEquals(CODIGO_CONTENEDORES_VENEZUELA);
	}

	private boolean hoyEsSabadoODomingo(DayOfWeek dayOfWeek) {
		return dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY);
	}

	private void validarCupos(HistorialAlmacenamiento historialAlmacenamiento) {
		boolean contenedorPerecedero = historialAlmacenamiento.getContenedor().getPerecedero();
		int cantidadContenedores = this.repositorioHistorialAlmacenamiento.cantidadContenedores(contenedorPerecedero);
		
		if(contenedorPerecedero && cantidadContenedores >= LIMITE_BODEGA_PERECEDEROS) {
			throw new ExcepcionCantidadContenedores(MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES_PERECEDEROS);
		}else if(!contenedorPerecedero && cantidadContenedores >= LIMITE_BODEGA_NO_PERECEDEROS) {
			throw new ExcepcionCantidadContenedores(MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES_NO_PERECEDEROS);
		}
	}

	public void validarContenedorAlmacenado(String codigo) {
		HistorialAlmacenamiento historialAlmacenamiento = this.repositorioHistorialAlmacenamiento.consultarHistorialAlmacenamiento(codigo);		
		if(estaAlmacenado(historialAlmacenamiento)) {
			throw new ExcepcionHistorialYaExistente(MENSAJE_HISTORIALALMACENAMIENTO_YA_EXISTENTE);
		}
		
	}

	public boolean estaAlmacenado(HistorialAlmacenamiento historialAlmacenamiento) {
		return historialAlmacenamiento != null && historialAlmacenamiento.getFechaSalida() == null;
	}
}
