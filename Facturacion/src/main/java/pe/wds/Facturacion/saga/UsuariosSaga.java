package pe.wds.Facturacion.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import pe.wds.Facturacion.command.UsuarioCredencialCmd;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;
import pe.wds.Facturacion.event.UsuarioCredencialEvent;

@Saga
public class UsuariosSaga {
    
    @Autowired
    private transient CommandGateway commandGateway;

    
    private String id;
    private String nombre;
    private String username;
  

    // @StartSaga
    // @SagaEventHandler(associationProperty = "id")
    // public void handle(UsuarioCreadoEvent usuarioCreadoEvent){
    //     System.out.println("caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + commandGateway);
    //     System.out.println("user cccccc caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + usuarioCreadoEvent);

    //     String userId = usuarioCreadoEvent.getId();

    //     String username = usuarioCreadoEvent.getUsername();

    //     commandGateway.send(new UsuarioCredencialCmd(UUID.randomUUID().toString(), usuarioCreadoEvent.getUsername(), usuarioCreadoEvent.getPassword()));

    // }

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void onEvent(UsuarioCreadoEvent usuarioCreadoEvent){
        System.out.println("caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + commandGateway);
        System.out.println("user cccccc caliiiiiiiiiiiiiiiiiiiiiiiii:::: " + usuarioCreadoEvent);

        String userId = usuarioCreadoEvent.getId();
        
        SagaLifecycle.associateWith("userId", userId);

        String id = UUID.randomUUID().toString();
        String username = usuarioCreadoEvent.getUsername();
        String name = usuarioCreadoEvent.getNombre();
        String password = usuarioCreadoEvent.getPassword();

        commandGateway.send(new UsuarioCredencialCmd(UUID.randomUUID().toString(), usuarioCreadoEvent.getUsername(), usuarioCreadoEvent.getPassword()));

    }


    @SagaEventHandler(associationProperty = "userId")
    public void handle(UsuarioCredencialEvent event){

        try {
            System.err.println("Saga UsuarioCredencialEvent : " + event.getUsername() + event);
            System.err.println("Name ::: " + event.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
