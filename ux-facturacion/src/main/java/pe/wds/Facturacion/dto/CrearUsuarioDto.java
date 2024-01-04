package pe.wds.Facturacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioDto {
    private String id;
    private String nombre;
    private String apellido;
    private String status;
    private String username;
	private String password;
    
}
