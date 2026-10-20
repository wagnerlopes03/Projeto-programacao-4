package com.br.projeto.controller;

import com.br.projeto.model.PostModel;
import com.br.projeto.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping
    public String paginaForum(Model model) {
        model.addAttribute("posts", forumService.listarTodos());
        return "forum/forum";
    }

    @GetMapping("/discussao/{id}")
    public String paginaDiscussao(@PathVariable Long id, Model model) {
        Optional<PostModel> postEscolhido = forumService.buscarPorId(id);
        model.addAttribute("post", postEscolhido.orElse(null));
        return "forum/discussao";
    }

    @PostMapping("/novo-topico/salvar")
    public String salvarTopico(PostModel post) {
        forumService.salvarTopico(post);
        return "redirect:/forum";
    }
}