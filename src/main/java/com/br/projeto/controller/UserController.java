package com.br.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
