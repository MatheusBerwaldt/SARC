package com.SARC.service;

import com.SARC.domain.Professor;
import com.SARC.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor obterPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deletarPorId(Long id) {
        professorRepository.deleteById(id);
    }
}
