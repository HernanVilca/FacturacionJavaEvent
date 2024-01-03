package pe.wds.Facturacion.service;

import java.util.concurrent.CompletableFuture;

import pe.wds.Facturacion.dto.UserDto;

public interface UserService {

    public CompletableFuture<String> CreateUser(UserDto userDto);
}
