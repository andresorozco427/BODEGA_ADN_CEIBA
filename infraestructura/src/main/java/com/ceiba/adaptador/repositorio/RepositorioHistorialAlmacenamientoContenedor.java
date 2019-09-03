package com.ceiba.adaptador.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.crudrepository.CrudHistorialAlmacenamientoRepository;
import com.ceiba.adaptador.entity.EntityHistorialAlmacenamiento;
import com.ceiba.adaptador.entity.orm.MapeoHistorialAlmacenamiento;
import com.ceiba.modelo.Contenedor;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;
import com.ceiba.puerto.repositorio.RepositorioHistorialAlmacenamiento;

@Repository
public class RepositorioHistorialAlmacenamientoContenedor implements RepositorioHistorialAlmacenamiento{

	private final CrudHistorialAlmacenamientoRepository CrudHistorialAlmacenamientoRepository;	
	
	public RepositorioHistorialAlmacenamientoContenedor(CrudHistorialAlmacenamientoRepository crudHistorialAlmacenamientoRepository) {
		this.CrudHistorialAlmacenamientoRepository = crudHistorialAlmacenamientoRepository;
	}

	@Override
	public void crearHistorial(HistorialAlmacenamiento historialAlmacenamiento) {
		EntityHistorialAlmacenamiento HistorialAlmacenamiento = this.CrudHistorialAlmacenamientoRepository.findByContenedorCodigo(historialAlmacenamiento.getContenedor().getCodigo());
		if(HistorialAlmacenamiento == null) {
			this.CrudHistorialAlmacenamientoRepository.save(MapeoHistorialAlmacenamiento.convertirAEntidad(historialAlmacenamiento));
		}else {
			this.CrudHistorialAlmacenamientoRepository.delete(HistorialAlmacenamiento);
			this.CrudHistorialAlmacenamientoRepository.save(MapeoHistorialAlmacenamiento.convertirAEntidad(historialAlmacenamiento));
		}
	}

	@Override
	public HistorialAlmacenamiento consultarHistorialAlmacenamiento(String codigo) {
		EntityHistorialAlmacenamiento entityHistorialAlmacenamiento = this.CrudHistorialAlmacenamientoRepository.findByContenedorCodigo(codigo);
		return MapeoHistorialAlmacenamiento.convertirAModelo(entityHistorialAlmacenamiento);
	}

	@Override
	public int cantidadContenedores(Contenedor contenedor) {
		int cantidadContenedores = 0;
		Iterable<EntityHistorialAlmacenamiento> listaContenedores = this.CrudHistorialAlmacenamientoRepository.findAll();
		for (EntityHistorialAlmacenamiento entityHistorialAlmacenamiento : listaContenedores) {
			if(entityHistorialAlmacenamiento.getFechaSalida() == null) {
				cantidadContenedores++;
			}
		}
		return cantidadContenedores;
	}

	@Override
	public SalidaHistorialAlmacenamiento actualizarHistorialAlmacenamiento(HistorialAlmacenamiento historial) {
		EntityHistorialAlmacenamiento entityHistorialAlmacenamiento = this.CrudHistorialAlmacenamientoRepository.findByContenedorCodigo(historial.getContenedor().getCodigo());
		entityHistorialAlmacenamiento.setFechaSalida(historial.getFechaSalida());
		entityHistorialAlmacenamiento.setPago(historial.getPago());
		this.CrudHistorialAlmacenamientoRepository.save(entityHistorialAlmacenamiento);
		
		return new SalidaHistorialAlmacenamiento(historial.getContenedor().getCodigo(), historial.getFechaIngreso(), historial.getFechaSalida(), historial.getPago());
	}

	@Override
	public List<HistorialAlmacenamiento> consultarContenedoresAlmacenadosEnLaBodega() {
		Iterable<EntityHistorialAlmacenamiento> listaContenedores = this.CrudHistorialAlmacenamientoRepository.findAll(); 
		return MapeoHistorialAlmacenamiento.convertirAModelo(listaContenedores);
	}

	@Override
	public HistorialAlmacenamiento consultarContenedorAlmacenado(String codigo) {
		EntityHistorialAlmacenamiento contenedorAlmacenado = this.CrudHistorialAlmacenamientoRepository.findByContenedorCodigo(codigo);
		return MapeoHistorialAlmacenamiento.convertirAModelo(contenedorAlmacenado);
	}

	@Override
	public boolean consultarSalidaContenedor(String codigo) {
		return false;
	}

}
