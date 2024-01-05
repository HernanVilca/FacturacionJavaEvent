package pe.wds.Facturacion.materialized.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;
import pe.wds.Facturacion.event.UsuarioDniConfirmadoEvent;
import pe.wds.Facturacion.materialized.dao.UsuarioDao;
import pe.wds.Facturacion.materialized.domain.UsuarioEntity;

@Component
@RequiredArgsConstructor
public class UsuarioEventHandler {

    private final UsuarioDao usuarioDao;
	
    @EventHandler
    public void handle(UsuarioCreadoEvent event) {
        String id = event.getId();
		String documentNumber = event.getDocumentNumber();
		String nombre = event.getNombre();
		String apellido = event.getApellido();

        String status = event.getStatus();

        System.out.println(id);
        System.out.println(documentNumber);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(status);
        System.out.println(" ooooooooooo CALI LLEGO TUS DATOS COMPLETOS PO JAJAJ XD xxxxxxxx");
		UsuarioEntity user = UsuarioEntity.builder().id(id).documentNumber(documentNumber)
				.nombre(nombre).apellido(apellido).status(status).build();

        System.out.println("ooooooooooo::: "+ user);
		usuarioDao.create(user);
    }

    @EventHandler
    public void handle(UsuarioDniConfirmadoEvent event) {
        String id = event.getId();
        System.out.println("UsuarioDniConfirmadoEvent CALI LLEGO TUS DATOS COMPLETOS PO JAJAJ XD"+ id);
    	UsuarioEntity usuarioOld = usuarioDao.getOne(id);
    	System.out.println("UsuarioDniConfirmadoEvent xxxxxxxx::: "+usuarioOld);
        usuarioOld.setStatus("ACTIVO");
		usuarioDao.update(usuarioOld);


    }
    
}
