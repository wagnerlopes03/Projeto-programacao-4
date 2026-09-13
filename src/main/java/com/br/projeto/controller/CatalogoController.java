package com.br.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @GetMapping("/cadastro-boneca")
    public String paginaCadastro(){
        return "catalogo/cadastro-boneca";
    }

    @GetMapping("/listagem")
    public String paginaListagem(){
        return "catalogo/listagem";
    }

    @GetMapping("/wiki")
    public String paginaWiki(){
        return "catalogo/wiki";
    }

}
