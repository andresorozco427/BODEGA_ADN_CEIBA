package com.ceiba.adaptador.crudrepository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ceiba.adaptador.entity.EntityHistorialAlmacenamiento;

@Component
public interface CrudHistorialAlmacenamientoRepository extends CrudRepository<EntityHistorialAlmacenamiento, Long>{
	
	public EntityHistorialAlmacenamiento findByContenedorCodigo(String codigo);
	
	public Iterable<EntityHistorialAlmacenamiento> findAllByFechaSalidaNotNull();
	
	public void deleteById(Long id);
}
