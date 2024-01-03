package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateEvent {
    private String id;
	private String nombre;
	private String apellido;
	
	
	private String username;
	
	private String password;
    
}
