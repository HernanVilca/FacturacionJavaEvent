package pe.wds.Facturacion.materialized.dao;

import java.util.List;

import pe.wds.Facturacion.materialized.domain.UsuarioEntity;

public interface UsuarioDao {

    UsuarioEntity getOne(String id);

	List<UsuarioEntity> getAll();

	
	UsuarioEntity create(UsuarioEntity entity );

	UsuarioEntity update(UsuarioEntity entity );
    
}
