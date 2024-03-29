package pe.wds.Facturacion.aggregate;

import org.axonframework.modelling.command.AggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {

    @AggregateIdentifier
	private String id;
    private String username;
	private String password;

    
    
}
