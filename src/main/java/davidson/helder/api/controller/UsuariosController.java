package davidson.helder.api.controller;

import davidson.helder.api.model.Usuario.Cadastro;
import org.springframework.web.bind.annotation.*;

import davidson.helder.api.model.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @PostMapping()
    public void cadastrarUsuario(@RequestBody Usuario novoUsuario) {
        Cadastro.cadastrarUsuario(new Cadastro(novoUsuario));
    }


}
