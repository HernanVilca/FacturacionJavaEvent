package pe.wds.Facturacion.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.wds.Facturacion.command.ConfirmarDniUsuarioCmd;
import pe.wds.Facturacion.command.CrearUsuarioCmd;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;
import pe.wds.Facturacion.event.UsuarioDniConfirmadoEvent;

@Getter
@Aggregate
@NoArgsConstructor
public class UsuarioAggregate {
    
    @AggregateIdentifier
    private String id;
    private String nombre;
    private String apellido;
    // private UserCredential credential;
    private String documentNumber;

    private String status;

    @CommandHandler
    public UsuarioAggregate(CrearUsuarioCmd cmd){
        String id = cmd.getId();
        String nombre = cmd.getNombre();
        String apellido = cmd.getApellido();
        String username = cmd.getUsername();

        String password = cmd.getPassword();
        String documentNumber = cmd.getDocumentNumber();
        System.out.println("tu DNI ES CORRECTO CALI:: "+ documentNumber);

        System.out.println("sssssssss poooososoosososondndddaajajaaajajja: "+ id);
        AggregateLifecycle.apply(UsuarioCreadoEvent.builder()
        .id(id)
        .nombre(nombre)
        .apellido(apellido)
        .username(username)
        .password(password)
        .documentNumber(documentNumber)
        .build());
    }

    @EventSourcingHandler
    public void onEvent(UsuarioCreadoEvent event){
        this.id = event.getId();
        this.nombre = event.getNombre();
        this.apellido = event.getApellido();
        this.documentNumber = event.getDocumentNumber();
        this.status = "CREATED";
    }


     @CommandHandler
    public void handle(ConfirmarDniUsuarioCmd cmd){
        String id = cmd.getId();
        // String status = cmd.getStatus();

        AggregateLifecycle.apply(UsuarioDniConfirmadoEvent.builder()
        .id(id)
        // .status(status)
        .build());
    }

    @EventSourcingHandler
    public void onEvent(UsuarioDniConfirmadoEvent event){
        id = event.getId();
        status = "ACTIVO";
    }
}
