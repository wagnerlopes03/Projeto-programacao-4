package com.br.projeto.controller;

import com.br.projeto.model.BonecaColecaoModel;
import com.br.projeto.service.CatalogoService;
import com.br.projeto.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    private final CatalogoService catalogoService;
    private final CategoriaService categoriaService;

    public CatalogoController(CatalogoService catalogoService, CategoriaService categoriaService) {
        this.catalogoService = catalogoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/cadastro-boneca")
    public String paginaCadastro(Model model) {
        model.addAttribute("boneca", new BonecaColecaoModel());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "catalogo/cadastro-boneca";
    }

    @PostMapping("/salvar")
    public String salvarBoneca(@ModelAttribute BonecaColecaoModel boneca) {
        catalogoService.salvarBoneca(boneca);
        return "redirect:/catalogo/listagem";
    }

    @GetMapping("/listagem")
    public String paginaListagem(Model model) {
        model.addAttribute("bonecas", catalogoService.listarTodas());
        return "catalogo/listagem";
    }

    @GetMapping("/wiki")
    public String paginaWiki() {
        return "catalogo/wiki";
    }
}