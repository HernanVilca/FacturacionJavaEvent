package pe.wds.Facturacion.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCredencialEvent {

    private String id;
    private String username;
	private String password;
}
