package com.br.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 255, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_boneca_fav")
    private BonecaColecaoModel bonecaFavorita;

    public UsuarioModel() {}

    public UsuarioModel(Integer id, String nome, String email, String senha, BonecaColecaoModel bonecaFavorita) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.bonecaFavorita = bonecaFavorita;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public BonecaColecaoModel getBonecaFavorita() { return bonecaFavorita; }
    public void setBonecaFavorita(BonecaColecaoModel bonecaFavorita) { this.bonecaFavorita = bonecaFavorita; }
}