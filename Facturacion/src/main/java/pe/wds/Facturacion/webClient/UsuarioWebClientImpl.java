package pe.wds.Facturacion.webClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

// @Repository
// @RequiredArgsConstructor
@Service
public class UsuarioWebClientImpl implements UsuarioWebClient{

    private final WebClient webClient;

    // public UsuarioWebClientImpl(WebClient webClient){
    //     this.webClient = webClient;

    // }

    public UsuarioWebClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

	
    @Override
    public Mono<Boolean> verifyAvabilityDocument(String dni) {
        return webClient.get().uri("/usuarios/" + dni)
            .retrieve()
            .bodyToMono(Boolean.class)  // Convierte el cuerpo de la respuesta a un Mono<Boolean>
            .defaultIfEmpty(false);    // Valor por defecto en caso de que el Mono sea vacío
    }
    
}
