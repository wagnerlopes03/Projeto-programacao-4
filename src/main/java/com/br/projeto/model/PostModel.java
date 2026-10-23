package com.br.projeto.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 255, message = "O título deve ter entre 5 e 255 caracteres")
    @Column(nullable = false)
    private String topico;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 255, message = "A descrição deve ter entre 10 e 255 caracteres")
    @Column(nullable = false)
    private String descricao;

    @NotNull(message = "Escolha uma categoria")
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModel categoria;

    @Column(name = "data_post", insertable = false, updatable = false)
    private LocalDateTime dataPost;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    public PostModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPost() {
        return dataPost;
    }

    public void setDataPost(LocalDateTime dataPost) {
        this.dataPost = dataPost;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}