package davidson.helder.api.dto;

import davidson.helder.api.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    public static class Lista {

        private static final List<Usuario> listaUsuarios = new ArrayList<>();

        public static void addUsuario(Usuario usuario) {
            if (usuarioExiste(usuario.getId())) return;
            listaUsuarios.add(usuario);
        }

        public static void removeUsuario(int id) {
            if (!usuarioExiste(id)) return;

            for (Usuario indexUsuario : listaUsuarios) {
                if (indexUsuario.getId() != id) continue;

                listaUsuarios.remove(indexUsuario);
                return;
            }
        }

        private static boolean usuarioExiste(int id) {
            for (Usuario indexUsuario : listaUsuarios) {
                if (indexUsuario.getId() != id) continue;

                return true;
            }
            return false;
        }

        public static List<Usuario> getListaUsuarios() {
            return listaUsuarios;
        }

        public static Usuario getUsuario(int id){

            if (!usuarioExiste(id)) return null;

            for (Usuario indexUsuario:
                    listaUsuarios) {

                if (indexUsuario.getId() != id) continue;

                return indexUsuario;
            }

            return null;
        }

    }

    public static class Cadastro {
        private final int id;
        private final String nome;
        private final String senha;
        private final String email;

        public Cadastro(Usuario usuario) {
            this.id = usuario.getId();
            this.nome = usuario.getNome();
            this.senha = usuario.getSenha();
            this.email = usuario.getEmail();
        }

        public static void cadastrarUsuario(Cadastro novoUsuario){
            Lista.addUsuario(new Usuario(
                    novoUsuario.id
                    , novoUsuario.nome
                    , novoUsuario.senha
                    , novoUsuario.email
            ));
        }

    }

}
