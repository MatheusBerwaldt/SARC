package com.SARC.mapper;

import org.mapstruct.Mapper;
import com.SARC.dto.DisciplineDTO;
import com.SARC.model.DisciplineEntity;

@Mapper(uses = {ClassMapper.class})
public interface DisciplineMapper {

    DisciplineDTO toDTO(DisciplineEntity disciplineEntity);
    DisciplineEntity toEntity(DisciplineDTO disciplineDTO);

}
