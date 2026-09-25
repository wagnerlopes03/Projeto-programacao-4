package com.br.projeto.model;

public class BonecaColecaoModel {
    private String nome;
    private String descricao;
    private String categoria;
    private int ano;
    private String fotoUrl;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

}