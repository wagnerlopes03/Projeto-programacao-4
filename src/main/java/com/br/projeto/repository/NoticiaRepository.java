package com.br.projeto.repository;

import com.br.projeto.model.NoticiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaModel, Integer> {
}