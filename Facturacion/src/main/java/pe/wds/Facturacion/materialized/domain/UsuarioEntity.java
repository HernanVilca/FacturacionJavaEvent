package pe.wds.Facturacion.materialized.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    private String id;
	
	private String documentNumber;
	
	private String nombre;
	
	private String apellido;
	
	private String status;
	
    
}
