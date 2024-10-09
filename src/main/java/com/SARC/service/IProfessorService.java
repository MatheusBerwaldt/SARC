package com.SARC.service;

import com.SARC.model.ProfessorEntity;
import com.SARC.dto.ProfessorDTO;

public interface IProfessorService {
    ProfessorEntity save(ProfessorDTO professorDTO);
    ProfessorEntity getById(long id);
    ProfessorEntity editById(long id, ProfessorDTO professorDTO);
}
