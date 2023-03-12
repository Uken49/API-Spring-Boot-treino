package davidson.helder.api.service;

import davidson.helder.api.model.Usuario;

public class UsuarioExibir {
    private final int id;
    private String nome;
    private String email;
    private boolean contaAutenticada;

    public UsuarioExibir(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.contaAutenticada = usuario.getContaAutenticada();
    }

    public UsuarioExibir exibirUsuario(int id){
        for (Usuario usuario : UsuarioLista.getListaUsuarios()) {
            if (usuario.getId() != id) continue;
            
            return new UsuarioExibir(usuario);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean getContaAutenticada() {
        return contaAutenticada;
    }
}
