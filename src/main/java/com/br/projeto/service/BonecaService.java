package com.br.projeto.service;

import com.br.projeto.model.BonecaColecaoModel;
import com.br.projeto.repository.BonecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonecaService {

    private final BonecaRepository bonecaRepository;

    public BonecaService(BonecaRepository bonecaRepository) {
        this.bonecaRepository = bonecaRepository;
    }

    public List<BonecaColecaoModel> listarTodas() {
        return bonecaRepository.findAll();
    }
}