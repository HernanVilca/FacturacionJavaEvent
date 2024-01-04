package pe.wds.Facturacion.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.wds.Facturacion.command.CrearUsuarioCmd;
import pe.wds.Facturacion.command.UsuarioCredencialCmd;
import pe.wds.Facturacion.event.UsuarioCreadoEvent;
import pe.wds.Facturacion.event.UsuarioCredencialEvent;

@Getter
@Aggregate
@NoArgsConstructor
public class UsuarioCredencial {

    @AggregateIdentifier
	private String id;
    private String username;
	private String password;

    @CommandHandler
    public UsuarioCredencial(UsuarioCredencialCmd cmd){
        String id = cmd.getId();
        String username = cmd.getUsername();
        String password = cmd.getPassword();

        AggregateLifecycle.apply(UsuarioCredencialEvent.builder()
        .id(id)
        .username(username)
        .password(password)
        .build());
    }

    @EventSourcingHandler
    public void onEvent(UsuarioCredencialEvent event){
        id = event.getId();
        username = event.getUsername();
        password = event.getPassword();
        
    }
    
}
