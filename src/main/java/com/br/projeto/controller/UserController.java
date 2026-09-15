package com.br.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/colecao")
    public String paginaColecao(){
        return "user/colecao";
    }

    @GetMapping("/perfil")
    public String paginaPerfil(){
        return "user/perfil";
    }
    @GetMapping("/posts")
    public String paginaPosts(){
        return "user/meus-posts";
    }

    @PostMapping("/perfil/atualizar")
    public String atualizarPerfil(){
        return "redirect:/user/perfil";
    }

    @PostMapping("/colecao/salvar")
    public String salvarBoneca(){
        return "redirect:/user/colecao";
    }
}
