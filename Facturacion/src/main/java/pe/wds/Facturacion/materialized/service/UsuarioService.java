package pe.wds.Facturacion.materialized.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.wds.Facturacion.materialized.dao.UsuarioDao;
import pe.wds.Facturacion.materialized.domain.UsuarioEntity;

@Service
public class UsuarioService {

    private final UsuarioDao usuarioDao;

    public UsuarioService(UsuarioDao usuarioDao){
        this.usuarioDao = usuarioDao;
    }
    // List<UsuarioEntity> getAll();

    public List<UsuarioEntity> getAll(){
        
        return this.usuarioDao.getAll();
    }

}
