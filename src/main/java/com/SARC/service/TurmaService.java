package com.SARC.service;

import com.SARC.domain.Turma;
import com.SARC.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Turma obterPorCodigo(Long codigo) {
        return turmaRepository.findById(codigo).orElse(null);
    }

    public Turma salvar(Turma turma) {
        if (turmaRepository.existsByCodigoAndDisciplinaCodigo(
                turma.getCodigo(), turma.getDisciplina().getCodigo())) {
            throw new IllegalArgumentException("Código de turma já existe para esta disciplina.");
        }
        return turmaRepository.save(turma);
    }

    public void deletarPorCodigo(Long codigo) {
        turmaRepository.deleteById(codigo);
    }
}

