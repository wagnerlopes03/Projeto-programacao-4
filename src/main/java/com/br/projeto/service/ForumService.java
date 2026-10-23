package com.br.projeto.service;

import com.br.projeto.model.NoticiaModel;
import com.br.projeto.model.PostModel;
import com.br.projeto.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    private final PostRepository postRepository;

    public ForumService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostModel> listarTodos() {
        return postRepository.findAll();
    }

    public Optional<PostModel> buscarPorId(Integer id) {
        return postRepository.findById(id);
    }

    public boolean salvarTopico(PostModel post) {
        boolean duplicado = postRepository.existsByUsuario_IdAndTopicoIgnoreCaseAndCategoria_Id(
                post.getUsuario().getId(),
                post.getTopico().trim(),
                post.getCategoria().getId()
        );

        if (duplicado) {
            return false;
        }

        postRepository.save(post);
        return true;
    }

    public List<PostModel> buscarUltimasPosts() {
        return postRepository.findTop3ByOrderByIdDesc();
    }
}