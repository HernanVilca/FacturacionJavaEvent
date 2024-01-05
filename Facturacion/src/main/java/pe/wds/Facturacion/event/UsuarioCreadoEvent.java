package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreadoEvent {
    private String id;
    private String nombre;
    private String apellido;
    // private UserCredential credential;
    private String documentNumber;
    private String status;
    
    private String username;
	private String password;

}
