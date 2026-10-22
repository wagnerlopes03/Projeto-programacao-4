package com.br.projeto.controller;

import com.br.projeto.model.PostModel;
import com.br.projeto.model.UsuarioModel;
import com.br.projeto.service.ForumService;
import jakarta.servlet.http.HttpSession;
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
    public String paginaForum(HttpSession session, Model model) {
        model.addAttribute("posts", forumService.listarTodos());
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        return "forum/forum";
    }

    @GetMapping("/discussao/{id}")
    public String paginaDiscussao(@PathVariable Integer id, HttpSession session, Model model) {
        Optional<PostModel> postEscolhido = forumService.buscarPorId(id);
        model.addAttribute("post", postEscolhido.orElse(null));
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        return "forum/discussao";
    }

    @PostMapping("/novo-topico/salvar")
    public String salvarTopico(PostModel post, HttpSession session) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/auth/login";
        }
        post.setUsuario(usuarioLogado);
        forumService.salvarTopico(post);

        return "redirect:/forum";
    }
}