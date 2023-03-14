package davidson.helder.api.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final int id;
    private String nome;
    private String senha;
    private String email;
    private boolean contaAutenticada;

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

    public Usuario(int id, String nome, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.contaAutenticada = false;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getContaAutenticada() {
        return contaAutenticada;
    }

    public void setcontaAutenticada(boolean contaAutenticada) {
        this.contaAutenticada = contaAutenticada;
    }

}
