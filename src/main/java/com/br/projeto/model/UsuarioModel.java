package com.br.projeto.model;

public class UsuarioModel {

    public String nome;
    public String email;
    public String senha;
    public String bonecaFavorita;

    public UsuarioModel(){}

    public UsuarioModel(String nome, String email, String senha, String bonecaFavorita) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bonecaFavorita = bonecaFavorita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBonecaFavorita() {
        return bonecaFavorita;
    }

    public void setBonecaFavorita(String bonecaFavorita) {
        this.bonecaFavorita = bonecaFavorita;
    }
}
