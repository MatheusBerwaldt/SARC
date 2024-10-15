package com.SARC.mapper;

import org.mapstruct.Mapper;

import com.SARC.dto.AlocationDTO;
import com.SARC.model.AlocationEntity;

@Mapper
public interface AlocationMapper {

    AlocationDTO toDto(AlocationEntity alocationEntity);
    AlocationEntity toEntity(AlocationDTO alocationDTO);

    //NECESSITA FAZER ANOTAÇÃO MAPPING
}
