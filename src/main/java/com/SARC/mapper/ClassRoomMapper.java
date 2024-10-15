package com.SARC.mapper;

import org.mapstruct.Mapper;

import com.SARC.dto.ClassRoomDTO;
import com.SARC.model.ClassRoomEntity;

@Mapper(uses = {AlocationMapper.class})
public interface ClassRoomMapper {
    ClassRoomDTO toDTO(ClassRoomEntity classRoomEntity);
    ClassRoomEntity toEntity(ClassRoomDTO classRoomDTO);

    //NECESSITA DE MAPPING
}