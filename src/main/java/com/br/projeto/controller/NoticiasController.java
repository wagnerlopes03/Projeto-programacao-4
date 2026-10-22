package com.br.projeto.controller;

import com.br.projeto.model.NoticiaModel;
import com.br.projeto.service.NoticiaService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

    private final NoticiaService noticiaService;

    public NoticiasController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public String listarNoticias(@RequestParam(defaultValue = "0") int pagina, Model model) {
        Page<NoticiaModel> paginaNoticias = noticiaService.buscarNoticiasPaginadas(pagina, 6);

        model.addAttribute("noticias", paginaNoticias.getContent());
        model.addAttribute("paginaAtual", pagina);
        model.addAttribute("totalPaginas", paginaNoticias.getTotalPages());

        return "noticias/noticias";
    }

}