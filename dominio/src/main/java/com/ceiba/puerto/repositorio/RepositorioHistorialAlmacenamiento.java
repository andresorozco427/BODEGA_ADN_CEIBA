/**
 * 
 */
package com.ceiba.puerto.repositorio;

import java.util.List;

import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;

/**
 * La cual nos permite la creacion de un historial de almacenamiento de un contenedor
 * @author andres.orozco
 *@version 1.0
 */
public interface RepositorioHistorialAlmacenamiento {
	
	public void crearHistorial(HistorialAlmacenamiento historialAlmacenamiento);
	
	public HistorialAlmacenamiento consultarHistorialAlmacenamiento(String codigo);
	
	public int cantidadContenedores(Contenedor contenedor);
	
	public SalidaHistorialAlmacenamiento actualizarHistorialAlmacenamiento(HistorialAlmacenamiento historial);

	public List<HistorialAlmacenamiento> consultarContenedoresAlmacenadosEnLaBodega();

	public HistorialAlmacenamiento consultarContenedorAlmacenado(String codigo);

	public boolean consultarSalidaContenedor(String codigo);
}
