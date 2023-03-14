package davidson.helder.api.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import davidson.helder.api.model.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @BeforeEach
    void limparListaECadastrarUsuario() {
        List<Usuario> listaUsuario = Usuario.Lista.getListaUsuarios();
        listaUsuario.clear();

        assertEquals(0, listaUsuario.size());


        Usuario.Cadastro usuario = new Usuario.Cadastro(
                new Usuario(0, "helder", "123", "helder@gmail.com")
        );

        Usuario.Cadastro.cadastrarUsuario(usuario);
        assertEquals(1, listaUsuario.size());
    }

    @Test
    @DisplayName("Cadastro de usuário")
    void cadastrarUsuario() {
        Usuario.Cadastro usuario = new Usuario.Cadastro(
                new Usuario(1, "joao", "123", "joao@bobo.com")
        );

        Usuario.Cadastro.cadastrarUsuario(usuario);
        assertEquals(2, Usuario.Lista.getListaUsuarios().size());

        Usuario.Cadastro.cadastrarUsuario(usuario);
        assertEquals(2, Usuario.Lista.getListaUsuarios().size());
    }

    @Test
    @DisplayName("Exibir um usuário")
    void exibirUmUsuario() {
        List<Usuario> listaUsuario = Usuario.Lista.getListaUsuarios();

        final int id = Usuario.Lista.getUsuario(0).getId();
        final String nome = Usuario.Lista.getUsuario(0).getNome();
        final String email = Usuario.Lista.getUsuario(0).getEmail();
        final boolean contaAutenticada = Usuario.Lista.getUsuario(0).getContaAutenticada();

        assertEquals(0, id);
        assertEquals("helder", nome);
        assertEquals("helder@gmail.com", email);
        assertFalse(contaAutenticada);

    }

}
