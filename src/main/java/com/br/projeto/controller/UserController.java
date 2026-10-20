package com.br.projeto.controller;

import com.br.projeto.model.BonecaColecaoModel;
import com.br.projeto.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UsuarioService usuarioService;
    private static final List<BonecaColecaoModel> minhaColecao = new ArrayList<>();
    private static boolean colecaoPublica = true;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/colecao")
    public String paginaColecao(Model model) {
        model.addAttribute("colecao", minhaColecao);
        model.addAttribute("colecaoPublica", colecaoPublica);
        return "user/colecao";
    }

    @PostMapping("/colecao/salvar")
    public String salvarBoneca(BonecaColecaoModel boneca) {
        minhaColecao.add(boneca);
        return "redirect:/user/colecao";
    }

    @GetMapping("/perfil")
    public String paginaPerfil() {
        return "user/perfil";
    }

    @GetMapping("/posts")
    public String paginaPosts() {
        return "user/meus-posts";
    }

    @PostMapping("/perfil/atualizar")
    public String atualizarPerfil() {
        return "redirect:/user/perfil";
    }
}