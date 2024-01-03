package pe.wds.Facturacion.ctrl;

import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import pe.wds.Facturacion.dto.UserDto;
import pe.wds.Facturacion.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserCtrl {

    private final UserService userService;

    @PostMapping
    public CompletableFuture<String> postMethodName(@RequestBody UserDto entity) {
        return userService.CreateUser(entity);
    }
}
