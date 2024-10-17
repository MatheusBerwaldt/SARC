package com.SARC.controller;

import com.SARC.domain.Disciplina;
import com.SARC.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public List<Disciplina> listarTodas() {
        return disciplinaService.listarTodas();
    }

    @GetMapping("/{codigo}")
    public Disciplina obterPorCodigo(@PathVariable String codigo) {
        return disciplinaService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Disciplina criarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    @PutMapping("/{codigo}")
    public Disciplina atualizarDisciplina(@PathVariable Long codigo, @RequestBody Disciplina disciplina) {
        disciplina.setCodigo(codigo);
        return disciplinaService.salvar(disciplina);
    }

    @DeleteMapping("/{codigo}")
    public void deletarDisciplina(@PathVariable String codigo) {
        disciplinaService.deletarPorCodigo(codigo);
    }
}
