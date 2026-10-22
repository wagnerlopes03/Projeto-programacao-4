package com.br.projeto.controller;
import com.br.projeto.service.ForumService;
import com.br.projeto.service.NoticiaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final NoticiaService noticiaService;
    private final ForumService forumService;

    public HomeController(NoticiaService noticiaService, ForumService forumService) {
        this.noticiaService = noticiaService;
        this.forumService = forumService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("noticias", noticiaService.buscarUltimasNoticias());
        model.addAttribute("posts", forumService.buscarUltimasPosts());
        return "index";
    }
}
