package pe.wds.Facturacion.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.wds.Facturacion.command.CrearUsuarioCmd;
import pe.wds.Facturacion.command.UsuarioCredencialCmd;
import pe.wds.Facturacion.dto.UsuarioCredencialDto;

@RequiredArgsConstructor
@Service
public class UsuarioCredencialImpl implements UsuarioCredencial{

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> CrearUsuarioCredencial(UsuarioCredencialDto usuarioCredencialDto) {
        return commandGateway.send(new UsuarioCredencialCmd(UUID.randomUUID().toString(), usuarioCredencialDto.getUsername(), usuarioCredencialDto.getPassword()));

    }

    
}
