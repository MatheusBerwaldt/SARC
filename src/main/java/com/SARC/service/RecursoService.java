package com.SARC.service;

import com.SARC.domain.Recurso;
import com.SARC.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<Recurso> listarTodos() {
        return recursoRepository.findAll();
    }

    public Recurso obterPorCodigo(Long codigo) {
        return recursoRepository.findById(codigo).orElse(null);
    }

    public Recurso salvar(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public void deletarPorCodigo(Long codigo) {
        recursoRepository.deleteById(codigo);
    }
}

