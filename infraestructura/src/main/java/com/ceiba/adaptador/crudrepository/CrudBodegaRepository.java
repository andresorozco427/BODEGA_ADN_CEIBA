package com.ceiba.adaptador.crudrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.entity.EntityBodega;

@Repository
public interface CrudBodegaRepository extends CrudRepository<EntityBodega, String>{

}
