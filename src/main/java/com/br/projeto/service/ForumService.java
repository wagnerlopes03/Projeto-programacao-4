package com.br.projeto.service;

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

    public PostModel salvarTopico(PostModel post) {
        return postRepository.save(post);
    }
}