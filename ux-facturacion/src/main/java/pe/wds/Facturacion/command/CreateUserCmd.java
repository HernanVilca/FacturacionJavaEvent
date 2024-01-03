package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class CreateUserCmd {
    @TargetAggregateIdentifier
	private String id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	
	public CreateUserCmd(){}
}
