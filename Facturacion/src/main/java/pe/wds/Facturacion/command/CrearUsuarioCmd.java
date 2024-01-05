package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CrearUsuarioCmd {

    @TargetAggregateIdentifier
    private String id;
    private String nombre;
    private String apellido;
    // private UserCredential credential;
    private String documentNumber;
    private String status;
    private String username;
	private String password;

    
}
