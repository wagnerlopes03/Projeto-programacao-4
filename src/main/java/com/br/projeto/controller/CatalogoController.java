package com.br.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.projeto.model.BonecaColecaoModel;
import com.br.projeto.repository.BonecaRepository;
import com.br.projeto.repository.CategoriaRepository;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private BonecaRepository bonecaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/cadastro-boneca")
    public String paginaCadastro(Model model){
        model.addAttribute("boneca", new BonecaColecaoModel());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "catalogo/cadastro-boneca";
    }

    @PostMapping("/salvar")
    public String salvarBoneca(@ModelAttribute BonecaColecaoModel boneca) {
        bonecaRepository.save(boneca);
        return "redirect:/catalogo/listagem";
    }

    @GetMapping("/listagem")
    public String paginaListagem(Model model) {
        model.addAttribute("bonecas", bonecaRepository.findAll());
        return "catalogo/listagem";
    }

    @GetMapping("/wiki")
    public String paginaWiki() {
        return "catalogo/wiki";
    }
}