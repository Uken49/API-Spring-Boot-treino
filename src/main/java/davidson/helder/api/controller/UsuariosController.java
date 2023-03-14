package davidson.helder.api.controller;

import davidson.helder.api.model.Usuario.Cadastro;
import davidson.helder.api.model.Usuario.Lista;
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

    @GetMapping()
    public List<Usuario> exibirListaUsuario(){
        return Lista.getListaUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario exibirUmUsuario(@PathVariable int id){
        return Lista.getUsuario(id);
    }

}
