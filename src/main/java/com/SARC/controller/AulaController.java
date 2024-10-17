package com.SARC.controller;

import com.SARC.domain.Aula;
import com.SARC.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/{turmaCodigo}/lesson")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public List<Aula> listarAulasPorTurma(@PathVariable Long turmaCodigo) {
        return aulaService.listarPorTurma(turmaCodigo);
    }

    @PostMapping
    public Aula criarAula(@PathVariable Long turmaCodigo, @RequestBody Aula aula) {
        aula.getTurma().setCodigo(turmaCodigo);
        return aulaService.salvar(aula);
    }

    @PutMapping("/{id}")
    public Aula atualizarAula(@PathVariable Long turmaCodigo, @PathVariable Long id, @RequestBody Aula aula) {
        aula.setId(id);
        aula.getTurma().setCodigo(turmaCodigo);
        return aulaService.salvar(aula);
    }

    @DeleteMapping("/{id}")
    public void deletarAula(@PathVariable Long id) {
        aulaService.deletarPorId(id);
    }
}
