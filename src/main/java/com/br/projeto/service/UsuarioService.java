package com.br.projeto.service;

import com.br.projeto.model.UsuarioModel;
import com.br.projeto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> autenticar(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}