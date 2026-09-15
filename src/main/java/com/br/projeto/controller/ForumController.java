package com.br.projeto.controller;

import com.br.projeto.model.PostModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private static final List<PostModel> listaPosts = new ArrayList<>();

    @GetMapping
    public String paginaForum(Model model){
        model.addAttribute("posts", listaPosts);
        return "forum/forum";
    }

    @GetMapping("/discussao")
    public String paginaDiscussao(){
        return "forum/discussao";
    }

    @PostMapping("/novo-topico/salvar")
    public String salvarTopico(PostModel post){
        listaPosts.add(post);
        return "redirect:/forum";
    }
}