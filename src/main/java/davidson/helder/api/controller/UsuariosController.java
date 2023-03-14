package davidson.helder.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidson.helder.api.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @PostMapping()
    public void cadastrarUsuario(@RequestBody Usuario novoUsuario) {
        new Usuario.Cadastro(novoUsuario);
    }

}
