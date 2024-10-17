package com.SARC.service;

import com.SARC.domain.Disciplina;
import com.SARC.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina obterPorCodigo(String codigo) {
        return disciplinaRepository.findById(codigo).orElse(null);
    }

    public Disciplina salvar(Disciplina disciplina) {
        if (disciplinaRepository.existsByCodigo(disciplina.getCodigo())) {
            throw new IllegalArgumentException("Código de disciplina já existe.");
        }
        return disciplinaRepository.save(disciplina);
    }

    public void deletarPorCodigo(String codigo) {
        disciplinaRepository.deleteById(codigo);
    }
}

