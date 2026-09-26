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
    private static Long contador = 1L;

    static {
        PostModel post1 = new PostModel();
        post1.setId((long) contador);
        post1.setCategoria("SOS com a Fada Madrinha");
        post1.setTitulo("Dicas pra guardar bonecas sem estragar a caixa?");
        post1.setTexto("por @rosa_pastel · 15 respostas");
        listaPosts.add(post1);
        contador++;

        PostModel post2 = new PostModel();
        post2.setId((long) contador);
        post2.setCategoria("Conversa com Princesas");
        post2.setTitulo("Qual filme da Barbie vocês assistiram mais vezes?");
        post2.setTexto("por @ken_fashionista · 21 respostas");
        listaPosts.add(post2);
        contador++;

        PostModel post3 = new PostModel();
        post3.setId((long) contador);
        post3.setCategoria("Caça ao Tesouro");
        post3.setTitulo("Achei minha Barbie Signature 65 Anos numa garagem sale!");
        post3.setTexto("por @rosa_colecionadora · 12 respostas");
        listaPosts.add(post3);
        contador++;
    }

    @GetMapping
    public String paginaForum(Model model){
        model.addAttribute("posts", listaPosts);
        return "forum/forum";
    }

    @GetMapping("/discussao/{id}")
    public String paginaDiscussao(@PathVariable Long id, Model model){
        PostModel postEscolhido = null;
        for (PostModel post : listaPosts) {
            if (post.getId().equals(id)){
                postEscolhido = post;
            }
        }
        model.addAttribute("post", postEscolhido);
        return "forum/discussao";
    }

    @PostMapping("/novo-topico/salvar")
    public String salvarTopico(PostModel post){
        post.setId(contador);
        listaPosts.add(post);
        contador++;
        return "redirect:/forum";
    }
}