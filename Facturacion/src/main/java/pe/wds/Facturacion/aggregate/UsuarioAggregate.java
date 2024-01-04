package pe.wds.Facturacion.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.wds.Facturacion.command.CrearUsuarioCmd;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;

@Getter
@Aggregate
@NoArgsConstructor
public class UsuarioAggregate {
    
    @AggregateIdentifier
    private String id;
    private String nombre;
    private String apellido;
    // private UserCredential credential;

    private String status;

    @CommandHandler
    public UsuarioAggregate(CrearUsuarioCmd cmd){
        String id = cmd.getId();
        String nombre = cmd.getNombre();
        String apellido = cmd.getApellido();
        String username = cmd.getUsername();

        String password = cmd.getPassword();

        System.out.println("sssssssss poooososoosososondndddaajajaaajajja: "+ id);
        AggregateLifecycle.apply(UsuarioCreadoEvent.builder()
        .id(id)
        .nombre(nombre)
        .apellido(apellido)
        .username(username)
        .password(password)
        .build());
    }

    @EventSourcingHandler
    public void onEvent(UsuarioCreadoEvent event){
        this.id = event.getId();
        this.nombre = event.getNombre();
        this.apellido = event.getApellido();
        this.status = "CREATED";
        
    }

}
