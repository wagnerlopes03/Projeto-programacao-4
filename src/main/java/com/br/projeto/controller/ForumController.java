package com.br.projeto.controller;

import com.br.projeto.model.PostModel;
import com.br.projeto.model.UsuarioModel;
import com.br.projeto.service.CategoriaService;
import com.br.projeto.service.ForumService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private final CategoriaService categoriaService;

    public ForumController(ForumService forumService, CategoriaService categoriaService) {
        this.forumService = forumService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String paginaForum(HttpSession session, Model model) {
        model.addAttribute("posts", forumService.listarTodos());
        model.addAttribute("usuarioLogado", session.getAttribute("usuarioLogado"));
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("post", new PostModel());
        return "forum/forum";
    }

    @PostMapping("/novo-topico/salvar")
    public String salvarTopico(@Valid @ModelAttribute("post") PostModel post,
                               BindingResult result,
                               HttpSession session,
                               Model model) {
        UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            return "redirect:/auth/login";
        }

        if (!result.hasErrors()) {
            post.setUsuario(usuarioLogado);
            if (forumService.salvarTopico(post)) {
                return "redirect:/forum";
            }
            result.rejectValue("topico", "regra.duplicado",
                    "Você já criou um tópico com esse título nessa categoria");
        }

        model.addAttribute("posts", forumService.listarTodos());
        model.addAttribute("usuarioLogado", usuarioLogado);
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("abrirForm", true);
        return "forum/forum";
    }
}