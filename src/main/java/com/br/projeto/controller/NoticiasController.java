package com.br.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

    @GetMapping("/noticias")
    public String paginaNoticias(){
        return "noticias/noticias";
    }
}
