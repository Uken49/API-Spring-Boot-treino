package davidson.helder.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidson.helder.api.model.Usuario;
import davidson.helder.api.service.UsuarioCadastro;
import davidson.helder.api.service.UsuarioLista;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @PostMapping()
    public void cadastrarUsuario(@RequestBody Usuario novoUsuario) {
        UsuarioCadastro usuario = new UsuarioCadastro(novoUsuario);
        usuario.cadastrarUsuario(usuario);
    }

}
