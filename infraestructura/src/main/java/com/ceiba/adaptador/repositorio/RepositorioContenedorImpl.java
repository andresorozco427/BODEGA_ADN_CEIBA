package com.ceiba.adaptador.repositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.crudrepository.CrudContenedorRepository;
import com.ceiba.adaptador.entity.orm.MapeoContenedor;
import com.ceiba.modelo.Contenedor;
import com.ceiba.puerto.repositorio.RepositorioContenedor;

@Repository
public class RepositorioContenedorImpl implements RepositorioContenedor{

	CrudContenedorRepository repositorioContenedor;
	
	@Autowired
	public RepositorioContenedorImpl(CrudContenedorRepository repositorioContenedor) {
		this.repositorioContenedor = repositorioContenedor;
	}
	
	@Override
	public void crear(Contenedor contenedor) {	
		repositorioContenedor.save(MapeoContenedor.convertirAEntidad(contenedor));
	}

}
