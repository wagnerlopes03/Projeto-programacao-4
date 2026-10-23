package com.br.projeto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bonecas")
public class BonecaColecaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModel categoria;

    private Integer ano;

    @Column(name = "link_foto")
    private String linkFoto;

    public BonecaColecaoModel() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public CategoriaModel getCategoria() { return categoria; }
    public void setCategoria(CategoriaModel categoria) { this.categoria = categoria; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getLinkFoto() { return linkFoto; }
    public void setLinkFoto(String linkFoto) { this.linkFoto = linkFoto; }
}