package pe.wds.Facturacion.ctrl;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.wds.Facturacion.dto.UsuarioCredencialDto;
import pe.wds.Facturacion.service.UsuarioCredencial;

@RestController
@RequestMapping(value = "/credenciales")
@AllArgsConstructor
public class UsuarioCredencialCtrl {
    
    private final UsuarioCredencial usuarioCredencial;
    @PostMapping
    public CompletableFuture<String> postMethodName(@RequestBody UsuarioCredencialDto entity) {
        return usuarioCredencial.CrearUsuarioCredencial(entity);
    }
    
}
