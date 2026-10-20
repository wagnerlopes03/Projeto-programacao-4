package com.br.projeto.service;

import com.br.projeto.model.CategoriaModel;
import com.br.projeto.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> listarTodas() {
        return categoriaRepository.findAll();
    }
}