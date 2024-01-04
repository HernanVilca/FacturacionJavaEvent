package pe.wds.Facturacion.ctrl;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.wds.Facturacion.dto.CrearUsuarioDto;
import pe.wds.Facturacion.service.CrearUsuarioService;

@RestController
// @RequestMapping("/usuarios")
@RequestMapping(value = "/usuarios")
@AllArgsConstructor
public class CrearUsuarioCtrl {
    
    private final CrearUsuarioService crearUsuarioService;

    @PostMapping
    public CompletableFuture<String> postMethodName(@RequestBody CrearUsuarioDto entity) {
        System.err.println("PPPPPSpppppp HASA :::: " + entity.getId());
        return crearUsuarioService.CrearUsuario(entity);
    }
}
