package davidson.helder.api.controller;

import davidson.helder.api.dto.UsuarioDTO.AtualizarUsuario;
import davidson.helder.api.dto.UsuarioDTO.Cadastro;
import davidson.helder.api.dto.UsuarioDTO.Lista;
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

    @PutMapping("/{id}/{nome}/{senha}")
    public void atualizarDados(
            @PathVariable int id
            ,@PathVariable String nome
            ,@PathVariable String senha
    ){
        AtualizarUsuario.atualizarDados(id, nome ,senha);
    }

    @PutMapping("/{id}/{email}")
    public void alterarEmail(
            @PathVariable int id
            ,@PathVariable String email
    ){
        AtualizarUsuario.alterarEmail(id, email);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable int id){
        Lista.removeUsuario(id);
    }

}
