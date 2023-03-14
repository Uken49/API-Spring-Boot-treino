package davidson.helder.api.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import davidson.helder.api.model.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @BeforeEach
    public void limparListaECadastrarUsuario(){
        List<Usuario> listaUsuario = UsuarioLista.getListaUsuarios();
        listaUsuario.clear();
        
        assertEquals(0, listaUsuario.size());
        

        UsuarioCadastro usuario = new UsuarioCadastro(
            new Usuario(0, "helder", "123", "email")
        );

        usuario.cadastrarUsuario(usuario);
        assertEquals(1, listaUsuario.size());
    }
   
    @Test
    @DisplayName("Cadastro de usuário")
    public void cadastrarUsuario() {
        UsuarioCadastro usuario = new UsuarioCadastro(
            new Usuario(1, "joao", "@321", "email")
        );

        usuario.cadastrarUsuario(usuario);

        usuario.cadastrarUsuario(usuario);
        assertEquals(2, UsuarioLista.getListaUsuarios().size());

        usuario.cadastrarUsuario(usuario);
        assertEquals(2, UsuarioLista.getListaUsuarios().size());
    }

    @Test
    @DisplayName("Exibir um usuário")
    public void exibirUmUsuario(){
        List<Usuario> listaUsuario = UsuarioLista.getListaUsuarios();

        final int id = UsuarioLista.getUsuario(0).getId();
        final String nome = UsuarioLista.getUsuario(0).getNome();
        final String email = UsuarioLista.getUsuario(0).getEmail();
        final boolean contaAutenticada = UsuarioLista.getUsuario(0).getContaAutenticada();

        assertEquals(0, id);
        assertEquals("helder", nome);
        assertEquals("email", email);
        assertFalse(contaAutenticada);

    }

}
