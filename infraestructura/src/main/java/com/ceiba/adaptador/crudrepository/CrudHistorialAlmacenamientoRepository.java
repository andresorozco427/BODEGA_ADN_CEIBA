package com.ceiba.adaptador.crudrepository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.entity.EntityHistorialAlmacenamiento;

@Repository
public interface CrudHistorialAlmacenamientoRepository extends CrudRepository<EntityHistorialAlmacenamiento, Long>{
	
	public EntityHistorialAlmacenamiento findByContenedorCodigo(String codigo);
	
	public Iterable<EntityHistorialAlmacenamiento> findByContenedorPerecedero(boolean esPerecedero);
	
	public Iterable<EntityHistorialAlmacenamiento> findAllByFechaSalidaNotNull();
	
	public Iterable<EntityHistorialAlmacenamiento> findAll();
	
	public void deleteById(Long id);
}
