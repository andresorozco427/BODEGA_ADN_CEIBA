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
import com.ceiba.puerto.repositorio.RepositorioContenedor;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

/**
 * @author andres.orozco
 *
 */
public class ServicioHistorialAlmacenamiento{
	private static final String MENSAJE_HISTORIALALMACENAMIENTO_YA_EXISTENTE = "El contenedor actualmente esta almacenado en la bodega";
	private static final String MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES = "No hay cupos disponibles para mas contenedores";
	private static final String MENSAJE_DIA_NO_HABIL_PARA_ALMACENAMIENTO = "El contenedor no puede ingresar, dia no habil";
	private static final String CODIGO_CONTENEDORES_ARGENTINA = "ar";
	private static final String CODIGO_CONTENEDORES_CHILE = "ch";
	private static final String CODIGO_CONTENEDORES_VENEZUELA = "ve";
	private static final int LIMITE_BODEGA = 30;

	private RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento;
	private RepositorioContenedor repositorioContenedor;
	
	public ServicioHistorialAlmacenamiento(RepositorioHistorialAlmacenamiento repositorioHistorialAlmacenamiento,
			RepositorioContenedor repositorioContenedor) {
		this.repositorioHistorialAlmacenamiento = repositorioHistorialAlmacenamiento;
		this.repositorioContenedor = repositorioContenedor;
	}
	
	public void ejecutarAlmacenamientoContenedor(Contenedor contenedor) {
		int totalCobrar = 0;
		LocalDateTime fechaIngreso = LocalDateTime.now();
		LocalDateTime fechaSalida = null;		
		HistorialAlmacenamiento historialAlmacenamiento = new HistorialAlmacenamiento(fechaIngreso, fechaSalida, contenedor, totalCobrar);
		
		validarContenedorAlmacenado(contenedor.getCodigo());
		validarCupos(contenedor);
		validarCodigoParaDiasHabiles(contenedor.getCodigo(), fechaIngreso.getDayOfWeek());
		
		this.repositorioContenedor.crear(contenedor);
		this.repositorioHistorialAlmacenamiento.crearHistorial(historialAlmacenamiento);
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

	private void validarCupos(Contenedor contenedor) {
		int cantidadContenedores = this.repositorioHistorialAlmacenamiento.cantidadContenedores(contenedor);
		
		if(cantidadContenedores >= LIMITE_BODEGA) {
			throw new ExcepcionCantidadContenedores(MENSAJE_NO_HAY_MAS_CUPOS_PARA_CONTENEDORES);
		}
	}

	private void validarContenedorAlmacenado(String codigo) {
		HistorialAlmacenamiento historialAlmacenamiento = this.repositorioHistorialAlmacenamiento.consultarHistorialAlmacenamiento(codigo);		
		if(estaAlmacenado(historialAlmacenamiento)) {
			throw new ExcepcionHistorialYaExistente(MENSAJE_HISTORIALALMACENAMIENTO_YA_EXISTENTE);
		}
		
	}

	private boolean estaAlmacenado(HistorialAlmacenamiento historialAlmacenamiento) {
		return historialAlmacenamiento != null && historialAlmacenamiento.getFechaSalida() == null;
	}
}
