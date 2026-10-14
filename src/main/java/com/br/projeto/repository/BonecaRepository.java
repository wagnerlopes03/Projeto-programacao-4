package com.br.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projeto.model.BonecaColecaoModel;

@Repository
public interface BonecaRepository extends JpaRepository<BonecaColecaoModel, Integer> {
}