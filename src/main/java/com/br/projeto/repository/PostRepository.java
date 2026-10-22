package com.br.projeto.repository;

import com.br.projeto.model.NoticiaModel;
import com.br.projeto.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {
    List<PostModel> findByTopicoContainingIgnoreCase(String topico);

    List<PostModel> findTop3ByOrderByIdDesc();
}