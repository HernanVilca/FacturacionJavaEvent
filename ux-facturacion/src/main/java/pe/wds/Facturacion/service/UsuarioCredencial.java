package pe.wds.Facturacion.service;

import java.util.concurrent.CompletableFuture;

import pe.wds.Facturacion.dto.UsuarioCredencialDto;

public interface UsuarioCredencial {

    public CompletableFuture<String> CrearUsuarioCredencial(UsuarioCredencialDto usuarioCredencialDto);

    
} 