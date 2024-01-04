package pe.wds.Facturacion.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import pe.wds.Facturacion.command.UsuarioCredencialCmd;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;

@Saga
public class UsuariosSaga {
    
    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handle(UsuarioCreadoEvent usuarioCreadoEvent){
        System.out.println("caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + commandGateway);
        System.out.println("user cccccc caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + usuarioCreadoEvent);

        commandGateway.send(new UsuarioCredencialCmd(UUID.randomUUID().toString(), usuarioCreadoEvent.getUsername(), usuarioCreadoEvent.getPassword()));

    }

}
