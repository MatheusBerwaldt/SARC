package com.SARC.service;

import com.SARC.model.ProfessorEntity;

import org.springframework.stereotype.Service;

import com.SARC.dto.ProfessorDTO;

@Service
public interface IProfessorService {
    ProfessorEntity save(ProfessorDTO professorDTO);
    ProfessorEntity getById(long id);
    ProfessorEntity editById(long id, ProfessorDTO professorDTO);
}
