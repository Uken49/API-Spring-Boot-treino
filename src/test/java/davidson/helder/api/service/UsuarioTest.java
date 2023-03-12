package davidson.helder.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import davidson.helder.api.model.Usuario;

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
            new Usuario(1, "helder", "123", "email")
        );

        usuario.cadastrarUsuario(usuario);

        usuario.cadastrarUsuario(usuario);
        assertEquals(2, UsuarioLista.getListaUsuarios().size());

        usuario.cadastrarUsuario(usuario);
        assertEquals(2, UsuarioLista.getListaUsuarios().size());
    }

    @Test
    @DisplayName("Exibir usuário")
    public void exibirUsuario() {
        List<Usuario> listaUsuario = UsuarioLista.getListaUsuarios();

        UsuarioExibir usuario = new UsuarioExibir(listaUsuario.get(0));

        assertEquals(0, usuario.getId());
        assertEquals("helder", usuario.getNome());
        assertEquals("email", usuario.getEmail());
        assertFalse(usuario.getContaAutenticada());

    }
}
