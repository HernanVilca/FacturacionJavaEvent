package pe.wds.Facturacion.service;

import java.util.concurrent.CompletableFuture;

import pe.wds.Facturacion.dto.CrearUsuarioDto;

public interface CrearUsuarioService {
    public CompletableFuture<String> CrearUsuario(CrearUsuarioDto crearUsuarioDto);
}
