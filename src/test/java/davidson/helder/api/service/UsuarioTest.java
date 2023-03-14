package davidson.helder.api.service;

import java.util.List;

import davidson.helder.api.dto.UsuarioDTO.Cadastro;
import davidson.helder.api.dto.UsuarioDTO.Lista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import davidson.helder.api.model.Usuario;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @BeforeEach
    void limparListaECadastrarUsuario() {
        List<Usuario> listaUsuario = Lista.getListaUsuarios();
        listaUsuario.clear();

        Cadastro usuario = new Cadastro(
                new Usuario(0, "helder", "123", "helder@gmail.com")
        );

        Cadastro.cadastrarUsuario(usuario);
        assertEquals(1, listaUsuario.size());
    }

    @Test
    @DisplayName("Cadastro de usuário")
    void cadastrarUsuario() {
        Cadastro usuario = new Cadastro(
                new Usuario(1, "joao", "123", "joao@bobo.com")
        );

        Cadastro.cadastrarUsuario(usuario);
        assertEquals(2, Lista.getListaUsuarios().size());

        Cadastro.cadastrarUsuario(usuario);
        assertEquals(2, Lista.getListaUsuarios().size());
    }

    @Test
    @DisplayName("Exibir um usuário")
    void exibirUmUsuario() {
        List<Usuario> listaUsuario = Lista.getListaUsuarios();

        final int id = Lista.getUsuario(0).getId();
        final String nome = Lista.getUsuario(0).getNome();
        final String email = Lista.getUsuario(0).getEmail();
        final boolean contaAutenticada = Lista.getUsuario(0).getContaAutenticada();

        assertEquals(0, id);
        assertEquals("helder", nome);
        assertEquals("helder@gmail.com", email);
        assertFalse(contaAutenticada);

    }

}
