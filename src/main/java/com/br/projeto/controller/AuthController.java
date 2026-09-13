package com.br.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/cadastro-usuario")
    public String paginaCadastro(){
        return "auth/cadastro-usuario";
    }

    @GetMapping("/login")
    public String paginaLogin() {
        return "auth/login";
    }

    @GetMapping("/recuperar-senha")
    public String paginaRecuperar (){
        return "auth/recuperar-senha";
    }
}
