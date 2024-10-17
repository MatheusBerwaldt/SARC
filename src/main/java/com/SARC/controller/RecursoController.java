package com.SARC.controller;

import com.SARC.domain.Recurso;
import com.SARC.service.RecursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public List<Recurso> listarTodos() {
        return recursoService.listarTodos();
    }

    @GetMapping("/{codigo}")
    public Recurso obterPorCodigo(@PathVariable Long codigo) {
        return recursoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Recurso criarRecurso(@RequestBody Recurso recurso) {
        return recursoService.salvar(recurso);
    }

    @PutMapping("/{codigo}")
    public Recurso atualizarRecurso(@PathVariable Long codigo, @RequestBody Recurso recurso) {
        recurso.setCodigo(codigo);
        return recursoService.salvar(recurso);
    }

    @DeleteMapping("/{codigo}")
    public void deletarRecurso(@PathVariable Long codigo) {
        recursoService.deletarPorCodigo(codigo);
    }
}
