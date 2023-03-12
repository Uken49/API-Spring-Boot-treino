package davidson.helder.api.service;

import java.util.ArrayList;
import java.util.List;

import davidson.helder.api.model.Usuario;

public abstract class UsuarioLista {

    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void addUsuario(Usuario usuario) {
        if (usuarioExiste(usuario.getId())) return;
        listaUsuarios.add(usuario);
    }

    public static void removeUsuario(int id) {
        if (!usuarioExiste(id)) return;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() != id) continue;

            listaUsuarios.remove(usuario);
            return;
        }
    }

    private static boolean usuarioExiste(int id) {
        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista.getId() != id) continue;

            return true;
        }
        return false;
    }

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

}
