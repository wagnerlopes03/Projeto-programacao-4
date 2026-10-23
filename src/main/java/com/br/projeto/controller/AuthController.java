package com.br.projeto.controller;

import com.br.projeto.model.UsuarioModel;
import com.br.projeto.service.BonecaService;
import com.br.projeto.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.validation.constraints.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final BonecaService bonecaService;

    public AuthController(UsuarioService usuarioService, BonecaService bonecaService) {
        this.usuarioService = usuarioService;
        this.bonecaService = bonecaService;
    }

    @GetMapping("/cadastro-usuario")
    public String paginaCadastro(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "auth/cadastro-usuario";
    }

    @PostMapping("/cadastro-usuario")
    public String cadastrar(@Valid @ModelAttribute("usuario") UsuarioModel usuario,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "auth/cadastro-usuario";
        }

        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String paginaLogin() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String autenticar(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session, Model model) {
        Optional<UsuarioModel> usuario = usuarioService.autenticar(email, senha);

        if (usuario.isPresent()) {
            session.setAttribute("usuarioLogado", usuario.get());
            return "redirect:/forum";
        }

        model.addAttribute("erro", "Usuário não encontrado ou senha incorreta!");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

    @GetMapping("/recuperar-senha")
    public String paginaRecuperar() {
        return "auth/recuperar-senha";
    }
}