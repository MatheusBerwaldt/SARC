package com.SARC.service;

import com.SARC.domain.Aula;
import com.SARC.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public List<Aula> listarPorTurma(Long turmaCodigo) {
        return aulaRepository.findByTurmaCodigo(turmaCodigo);
    }

    public Aula salvar(Aula aula) {
        if (aulaRepository.existsByTurmaCodigoAndDataAndHorario(
                aula.getTurma().getCodigo(), aula.getData(), aula.getHorario())) {
            throw new IllegalArgumentException("Já existe uma aula para esta turma neste horário.");
        }
        return aulaRepository.save(aula);
    }

    public void deletarPorId(Long id) {
        aulaRepository.deleteById(id);
    }
}

