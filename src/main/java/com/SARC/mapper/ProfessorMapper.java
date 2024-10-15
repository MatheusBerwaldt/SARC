package com.SARC.mapper;

import org.mapstruct.Mapper;

import com.SARC.dto.ProfessorDTO;
import com.SARC.model.ProfessorEntity;

@Mapper(uses = { ClassMapper.class})
public interface ProfessorMapper {

    ProfessorDTO toDTO(ProfessorEntity professorEntity);
    ProfessorEntity toEntity(ProfessorDTO professorDTO);

}
