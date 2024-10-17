package com.SARC.controller;

import com.SARC.domain.Professor;
import com.SARC.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Professor obterPorId(@PathVariable Long id) {
        return professorService.obterPorId(id);
    }

    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        return professorService.salvar(professor);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorService.deletarPorId(id);
    }
}
