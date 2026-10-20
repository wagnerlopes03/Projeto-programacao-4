package com.br.projeto.controller;

import com.br.projeto.model.UsuarioModel;
import com.br.projeto.service.BonecaService;
import com.br.projeto.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("bonecas", bonecaService.listarTodas());
        return "auth/cadastro-usuario";
    }

    @PostMapping("/cadastro-usuario")
    public String cadastrar(UsuarioModel usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String paginaLogin() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String autenticar(@RequestParam("email") String email,
                             @RequestParam("senha") String senha,
                             Model model) {

        Optional<UsuarioModel> usuario = usuarioService.autenticar(email, senha);

        if (usuario.isPresent()) {
            return "redirect:/user/perfil";
        }

        model.addAttribute("erro", "Usuário não encontrado ou senha incorreta!");
        return "auth/login";
    }

    @GetMapping("/recuperar-senha")
    public String paginaRecuperar() {
        return "auth/recuperar-senha";
    }
}