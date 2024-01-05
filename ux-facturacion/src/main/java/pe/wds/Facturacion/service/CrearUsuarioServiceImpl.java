package pe.wds.Facturacion.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.wds.Facturacion.command.CrearUsuarioCmd;
import pe.wds.Facturacion.dto.CrearUsuarioDto;

@RequiredArgsConstructor
@Service
public class CrearUsuarioServiceImpl implements CrearUsuarioService {

    private final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> CrearUsuario(CrearUsuarioDto crearUsuarioDto) {
        System.out.println("caliiiiiiiiiiiiiiiii::::::: " + crearUsuarioDto.getId());
        
        return commandGateway.send(new CrearUsuarioCmd(UUID.randomUUID().toString(), 
        crearUsuarioDto.getNombre(),
        crearUsuarioDto.getApellido(),
        crearUsuarioDto.getDocumentNumber(), 
        crearUsuarioDto.getStatus(),
        crearUsuarioDto.getUsername(), 
        crearUsuarioDto.getPassword()
        ));
    } 


}
