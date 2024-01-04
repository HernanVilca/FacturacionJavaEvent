package pe.wds.Facturacion.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UsuarioCredencialCmd {
    
    @TargetAggregateIdentifier
    private String id;
    private String username;
	private String password;

    public UsuarioCredencialCmd(){}
}
