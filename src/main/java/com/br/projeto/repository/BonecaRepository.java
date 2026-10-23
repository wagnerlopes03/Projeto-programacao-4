package com.br.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projeto.model.BonecaColecaoModel;

import java.util.List;

@Repository
public interface BonecaRepository extends JpaRepository<BonecaColecaoModel, Integer> {

    List<BonecaColecaoModel> findByCategoria_Nome(String nome);
}