package com.br.projeto.controller;
import com.br.projeto.model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <- IMPORT CORRETO DO SPRING
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private static final List<UsuarioModel> ListaUsuarios = new ArrayList<>();

    public static List<UsuarioModel> getListaUsuarios(){
        return ListaUsuarios;
    }

    @GetMapping("/cadastro-usuario")
    public String paginaCadastro(){
        return "auth/cadastro-usuario";
    }

    @PostMapping("/cadastro-usuario")
    public String cadastrar(UsuarioModel usuario){
        ListaUsuarios.add(usuario);
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

        for (UsuarioModel u : ListaUsuarios) {
            if (u.getEmail() != null && u.getEmail().equals(email) &&
                    u.getSenha() != null && u.getSenha().equals(senha)) {
                return "redirect:/user/perfil";
            }
        }

        model.addAttribute("erro", "Usuário não encontrado ou senha incorreta!");
        return "auth/login";
    }

    @GetMapping("/recuperar-senha")
    public String paginaRecuperar (){
        return "auth/recuperar-senha";
    }
}