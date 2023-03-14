package davidson.helder.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
    private final int id;
    private String nome;
    private String senha;
    private String email;
    private boolean contaAutenticada;

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

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
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
