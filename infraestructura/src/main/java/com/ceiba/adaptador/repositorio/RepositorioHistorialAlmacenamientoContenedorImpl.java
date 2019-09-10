package com.ceiba.adaptador.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.crudrepository.CrudHistorialAlmacenamientoRepository;
import com.ceiba.adaptador.entity.EntityHistorialAlmacenamiento;
import com.ceiba.adaptador.entity.orm.MapeoHistorialAlmacenamiento;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

@Repository
public class RepositorioHistorialAlmacenamientoContenedorImpl implements RepositorioHistorialAlmacenamiento{

	private final CrudHistorialAlmacenamientoRepository crudHistorialAlmacenamientoRepository;
	
	public RepositorioHistorialAlmacenamientoContenedorImpl(CrudHistorialAlmacenamientoRepository crudHistorialAlmacenamientoRepository) {
		this.crudHistorialAlmacenamientoRepository = crudHistorialAlmacenamientoRepository;
	}

	@Override
	public void crearHistorial(HistorialAlmacenamiento historialAlmacenamiento) {
			this.crudHistorialAlmacenamientoRepository.save(MapeoHistorialAlmacenamiento.convertirAEntidad(historialAlmacenamiento));
	}

	@Override
	public HistorialAlmacenamiento consultarHistorialAlmacenamiento(String codigo) {
		EntityHistorialAlmacenamiento entityHistorialAlmacenamiento = this.crudHistorialAlmacenamientoRepository.findByContenedorCodigo(codigo);
		return MapeoHistorialAlmacenamiento.convertirAModelo(entityHistorialAlmacenamiento);
	}


	@Override
	public int cantidadContenedores(boolean contenedorPerecedero) {
		int cantidadContenedores = 0;
		List<EntityHistorialAlmacenamiento> listaContenedores = (List<EntityHistorialAlmacenamiento>) this.crudHistorialAlmacenamientoRepository.findByContenedorPerecedero(contenedorPerecedero);
		for (EntityHistorialAlmacenamiento entityHistorialAlmacenamiento : listaContenedores) {			
			if(entityHistorialAlmacenamiento.getFechaSalida() == null) {
				cantidadContenedores++;
			}
		}		
		
		return cantidadContenedores;
	}

	@Override
	public SalidaHistorialAlmacenamiento actualizarHistorialAlmacenamiento(HistorialAlmacenamiento historial) {
		EntityHistorialAlmacenamiento entityHistorialAlmacenamiento = this.crudHistorialAlmacenamientoRepository.findByContenedorCodigo(historial.getContenedor().getCodigo());
		entityHistorialAlmacenamiento.setFechaSalida(historial.getFechaSalida());
		entityHistorialAlmacenamiento.setPago(historial.getPago());
		this.crudHistorialAlmacenamientoRepository.save(entityHistorialAlmacenamiento);
		
		return new SalidaHistorialAlmacenamiento(historial.getContenedor().getCodigo(), historial.getFechaIngreso(),historial.getFechaSalida(), historial.getPago());
	}

	@Override
	public List<HistorialAlmacenamiento> consultarContenedoresAlmacenadosEnLaBodega() {
		Iterable<EntityHistorialAlmacenamiento> listaContenedores = this.crudHistorialAlmacenamientoRepository.findAll();
		return MapeoHistorialAlmacenamiento.convertirAModelo(listaContenedores);
	}

	@Override
	public HistorialAlmacenamiento consultarContenedorAlmacenado(String codigo) {
		EntityHistorialAlmacenamiento contenedorAlmacenado = this.crudHistorialAlmacenamientoRepository.findByContenedorCodigo(codigo);
		return MapeoHistorialAlmacenamiento.convertirAModelo(contenedorAlmacenado);
	}

	@Override
	public boolean elContenedorSeEncuentraAlmacenado(String codigo) {
		EntityHistorialAlmacenamiento historialAlmacenamiento = this.crudHistorialAlmacenamientoRepository.findByContenedorCodigo(codigo);
		return historialAlmacenamiento.getFechaSalida() != null;
	}

//	@Override
//	public List<HistorialAlmacenamiento> consultaHistorialAlmacenamientoContenedoresPerecederos() {
//		Iterable<EntityHistorialAlmacenamiento> listaContenedores = this.crudHistorialAlmacenamientoRepository.findAllByContenedorPerecedero();
//		return MapeoHistorialAlmacenamiento.convertirAModelo(listaContenedores);
//	}


}
