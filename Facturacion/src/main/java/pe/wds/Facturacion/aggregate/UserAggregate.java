package pe.wds.Facturacion.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.wds.Facturacion.command.CreateUserCmd;
import pe.wds.Facturacion.event.UserCreateEvent;

@Getter
@Aggregate
@NoArgsConstructor
public class UserAggregate {

    
	@AggregateIdentifier
	private String id;
	
	private String nombre;

	private String apellido;
	
	private UserCredential credential;

	private String status;
	
	@CommandHandler
	public UserAggregate(CreateUserCmd cmd){
		String id = cmd.getId();
		String nombre = cmd.getNombre();
		String apellido = cmd.getApellido();
		String userName = cmd.getUsername();
		String password = cmd.getPassword();
		AggregateLifecycle.apply(UserCreateEvent.builder()
				.id(id)
				.nombre(nombre)
				.apellido(apellido)
				.username(userName)
				.password(password)
				.build());
	}
	
	@EventSourcingHandler
	public void onEvent(UserCreateEvent event) {
		id = event.getId();
		nombre = event.getNombre();
		apellido = event.getApellido();
		String userName = event.getUsername();
		String password = event.getPassword();
		credential = UserCredential.builder().username(userName).password(password).build();
	}
    
}
