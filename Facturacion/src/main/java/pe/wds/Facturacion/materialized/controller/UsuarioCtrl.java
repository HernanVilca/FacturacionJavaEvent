package pe.wds.Facturacion.materialized.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pe.wds.Facturacion.materialized.dao.UsuarioDao;
import pe.wds.Facturacion.materialized.service.UsuarioService;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioCtrl {
    
    // @Autowired
    // private final UsuarioService usuarioDao;
	
    private final UsuarioDao usuarioDao;

	@GetMapping("/{dni}")
	public Boolean verifyAvabilityDni(@PathVariable String dni) {

        System.out.println("+++++++++++ Si llego tu dni xd calllllll 7777778:: "+ dni);

        System.out.println(usuarioDao.getAll());
        System.out.println("+++++++++++2222222222 Si llego tu dni xd calllllll 7777778:: "+ dni);
        return usuarioDao.getAll().stream().filter(user-> {
            System.out.println("xxxxx mmmm ooooo pppppppp ::::: "+ user); 
			return user.getDocumentNumber().equals(dni)  && "ACTIVO".equals(user.getStatus());
		}).findFirst().isPresent();
		
	}

//     @GetMapping("/{dni}")
//     public Mono<Boolean> verifyAvabilityDni(@PathVariable String dni) {
//         return usuarioDao.getAll()
//             .filter(user -> user.getDocumentNumber().equals(dni) && "ACTIVO".equals(user.getStatus()))
//             .hasElements();
//     }

//     @GetMapping("/{dni}")
// public Mono<Boolean> verifyAvailabilityDni(@PathVariable String dni) {
//     return usuarioDao.getAll()
//         .any(user -> user.getDocumentNumber().equals(dni) && "ACTIVO".equals(user.getStatus()));
// }

    @GetMapping
	public String getCali() {
		
		// return usuarioDao.getAll().stream().filter(user-> { 
		// 	return user.getDocumentNumber().equals(dni)  && "ACTIVO".equals(user.getStatus());
		// }).findFirst().isPresent();
		
        return "Si funca cali xd calcula la distancia del rayo ";
		
	}
}
