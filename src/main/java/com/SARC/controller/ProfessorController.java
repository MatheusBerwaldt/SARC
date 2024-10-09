package com.SARC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SARC.dto.ProfessorDTO;
import com.SARC.model.ProfessorEntity;
import com.SARC.service.IProfessorService;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private IProfessorService professorService;

    @PostMapping
    public ProfessorEntity save(@RequestBody ProfessorDTO professorDTO){
        return this.professorService.save(professorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> getByID(@PathVariable(value = "id") long professorId){
        ProfessorEntity professor = this.professorService.getById(professorId);
        return (professor == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorEntity> editByID(@PathVariable(value = "id") long professorId, @RequestBody ProfessorDTO professorDTO){
        ProfessorEntity save = this.professorService.editById(professorId, professorDTO);
        return(save == null) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(save);
    }

}
