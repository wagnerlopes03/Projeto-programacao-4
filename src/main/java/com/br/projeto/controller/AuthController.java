package com.br.projeto.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.projeto.model.UsuarioModel;
import com.br.projeto.repository.BonecaRepository;
import com.br.projeto.repository.UsuarioRepository;


@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final BonecaRepository bonecaRepository;

    public AuthController(UsuarioRepository usuarioRepository, BonecaRepository bonecaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.bonecaRepository = bonecaRepository;
    }

    @GetMapping("/cadastro-usuario")
    public String paginaCadastro(Model model) {
        model.addAttribute("bonecas", bonecaRepository.findAll());
        return "auth/cadastro-usuario";
    }

    @PostMapping("/cadastro-usuario")
    public String cadastrar(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
        System.out.println("Novo Usuário Cadastrado: " + usuario.getEmail());
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

        Optional<UsuarioModel> usuario = usuarioRepository.findByEmailAndSenha(email, senha);

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
