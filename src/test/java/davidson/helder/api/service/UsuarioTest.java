package davidson.helder.api.service;

import davidson.helder.api.dto.UsuarioDTO.AtualizarUsuario;
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
        Lista.getListaUsuarios().clear();

        Cadastro usuario = new Cadastro(
                new Usuario(0, "helder", "123", "helder@gmail.com")
        );

        Cadastro.cadastrarUsuario(usuario);
        assertEquals(1, Lista.getListaUsuarios().size());
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

        final int id = Lista.getUsuario(0).getId();
        final String nome = Lista.getUsuario(0).getNome();
        final String email = Lista.getUsuario(0).getEmail();
        final boolean contaAutenticada = Lista.getUsuario(0).isContaAutenticada();

        assertEquals(0, id);
        assertEquals("helder", nome);
        assertEquals("helder@gmail.com", email);
        assertFalse(contaAutenticada);

    }

    @Test
    @DisplayName("Excluir usuário")
    void excluirUsuario(){
        Lista.removeUsuario(0);
        assertEquals(0, Lista.getListaUsuarios().size());
    }

    @Test
    @DisplayName("Atualizar usuário")
    void atualizarUsuario(){
        AtualizarUsuario.atualizarDados(0, "harley", "segura");

        assertEquals(1, Lista.getListaUsuarios().size());

        final int id = Lista.getUsuario(0).getId();
        final String nome = Lista.getUsuario(0).getNome();
        final String email = Lista.getUsuario(0).getEmail();
        final String senha = Lista.getUsuario(0).getSenha();
        final boolean contaAutenticada = Lista.getUsuario(0).isContaAutenticada();

        assertEquals(0, id);
        assertEquals("harley", nome);
        assertEquals("segura", senha);
        assertEquals("helder@gmail.com", email);
        assertFalse(contaAutenticada);
    }

    @Test
    @DisplayName("Atualizar email")
    void alterarEmail(){
        AtualizarUsuario.alterarEmail(0, "meci@goat.com");

        assertEquals(1, Lista.getListaUsuarios().size());

        final int id = Lista.getUsuario(0).getId();
        final String nome = Lista.getUsuario(0).getNome();
        final String email = Lista.getUsuario(0).getEmail();
        final String senha = Lista.getUsuario(0).getSenha();
        final boolean contaAutenticada = Lista.getUsuario(0).isContaAutenticada();

        assertEquals(0, id);
        assertEquals("helder", nome);
        assertEquals("123", senha);
        assertEquals("meci@goat.com", email);
        assertFalse(contaAutenticada);
    }

}
