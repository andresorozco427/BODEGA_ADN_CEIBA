package com.ceiba.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.crudrepository.CrudBodegaRepository;
import com.ceiba.adaptador.entity.orm.MapeoBodega;
import com.ceiba.modelo.bodega.BodegaAlmacenaje;
import com.ceiba.puerto.repositorio.RepositorioBodega;

@Repository
public class RespositorioBodegaImpl implements RepositorioBodega{

	private CrudBodegaRepository crudBodegaRepository;
	
	@Autowired
	public RespositorioBodegaImpl(CrudBodegaRepository crudBodegaRepository) {
		this.crudBodegaRepository = crudBodegaRepository;
	}

	@Override
	public void crear(BodegaAlmacenaje bodegaAlmacenaje) {
		crudBodegaRepository.save(MapeoBodega.convertirAEntidad(bodegaAlmacenaje));		
	}

}
