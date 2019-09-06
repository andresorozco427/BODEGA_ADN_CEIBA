package com.ceiba.adaptador.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.entity.EntityContenedor;

@Repository
public interface CrudContenedorRepository extends CrudRepository<EntityContenedor, String>{

}
