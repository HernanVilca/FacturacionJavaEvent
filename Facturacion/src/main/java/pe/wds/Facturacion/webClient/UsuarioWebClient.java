package pe.wds.Facturacion.webClient;

import reactor.core.publisher.Mono;

public interface UsuarioWebClient  {

    Mono<Boolean> verifyAvabilityDocument(String dni);
    
}
