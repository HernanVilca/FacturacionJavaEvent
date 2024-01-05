package pe.wds.Facturacion.materialized.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import pe.wds.Facturacion.materialized.domain.UsuarioEntity;

@Repository
public class UsuarioDaoMemory implements UsuarioDao {
    List<UsuarioEntity> entities = new LinkedList<UsuarioEntity>();
	
	@Override
	public UsuarioEntity getOne(String id) {
		Optional<UsuarioEntity> entity = entities.stream().filter(item->item.getId().equalsIgnoreCase(id)).findFirst();		
		if(entity.isEmpty()) {
			return null;
		}
		return entity.get();
	}

	@Override
	public UsuarioEntity create(UsuarioEntity entity) {
		entities.add(entity);
		return entity;
	}

	@Override
	public UsuarioEntity update(UsuarioEntity entity) {

		UsuarioEntity old = this.getOne(entity.getId());
		old.setNombre(entity.getNombre());
		old.setApellido(entity.getApellido());
		old.setDocumentNumber(entity.getDocumentNumber());
		return old;
	}

	@Override
	public List<UsuarioEntity> getAll() {
		return this.entities;
	}
}
