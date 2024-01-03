package pe.wds.Facturacion.service;

import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.wds.Facturacion.command.CreateUserCmd;
import pe.wds.Facturacion.dto.UserDto;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final CommandGateway commandGateway; 

    @Override
    public CompletableFuture<String> CreateUser(UserDto userDto) {
        return commandGateway.send(new CreateUserCmd(userDto.getId(), userDto.getNombre(), userDto.getApellido(), userDto.getUsername(), userDto.getPassword()));
    }
    
}
