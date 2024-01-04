package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCredencialCmd {

    @TargetAggregateIdentifier
    private String id;
    private String username;
	private String password;

}
