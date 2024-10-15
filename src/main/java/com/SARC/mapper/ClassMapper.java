package com.SARC.mapper;

import org.mapstruct.Mapper;

import com.SARC.dto.ClassDTO;
import com.SARC.model.ClassEntity;

@Mapper(uses = { ClassRoomMapper.class})
public interface ClassMapper {
    ClassDTO toDTO(ClassEntity classEntity);
    ClassEntity toEntity(ClassDTO classDTO);
    //NECESSITA DE MAPPING
}
