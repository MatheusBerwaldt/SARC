package com.SARC.controller;

import com.SARC.domain.Turma;
import com.SARC.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> listarTodas() {
        return turmaService.listarTodas();
    }

    @GetMapping("/{codigo}")
    public Turma obterPorCodigo(@PathVariable Long codigo) {
        return turmaService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Turma criarTurma(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }

    @PutMapping("/{codigo}")
    public Turma atualizarTurma(@PathVariable Long codigo, @RequestBody Turma turma) {
        turma.setCodigo(codigo);
        return turmaService.salvar(turma);
    }

    @DeleteMapping("/{codigo}")
    public void deletarTurma(@PathVariable Long codigo) {
        turmaService.deletarPorCodigo(codigo);
    }
}
