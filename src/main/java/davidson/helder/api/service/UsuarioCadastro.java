package davidson.helder.api.service;

import davidson.helder.api.model.Usuario;

public class UsuarioCadastro {
    private final int id;
    private final String nome;
    private final String senha;
    private final String email;

    public UsuarioCadastro(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.email = usuario.getEmail();
    }

    public void cadastrarUsuario(UsuarioCadastro novoUsuario){
        UsuarioLista.addUsuario(new Usuario(
            novoUsuario.id
            , novoUsuario.nome
            , novoUsuario.senha
            , novoUsuario.email
            ));
    }
    
}
