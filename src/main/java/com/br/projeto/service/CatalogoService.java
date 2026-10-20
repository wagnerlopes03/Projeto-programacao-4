package com.br.projeto.service;

import com.br.projeto.model.BonecaColecaoModel;
import com.br.projeto.repository.BonecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    private final BonecaRepository bonecaRepository;

    public CatalogoService(BonecaRepository bonecaRepository) {
        this.bonecaRepository = bonecaRepository;
    }

    public BonecaColecaoModel salvarBoneca(BonecaColecaoModel boneca) {
        return bonecaRepository.save(boneca);
    }

    public List<BonecaColecaoModel> listarTodas() {
        return bonecaRepository.findAll();
    }
}