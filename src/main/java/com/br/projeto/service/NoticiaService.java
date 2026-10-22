package com.br.projeto.service;

import com.br.projeto.model.NoticiaModel;
import com.br.projeto.repository.NoticiaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public Page<NoticiaModel> buscarNoticiasPaginadas(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by("dataPublicacao").descending());
        return noticiaRepository.findAll(pageable);
    }

    public List<NoticiaModel> buscarUltimasNoticias() {
        return noticiaRepository.findTop3ByOrderByIdDesc();
    }
}