package com.SARC.mapper;

import org.mapstruct.Mapper;

import com.SARC.dto.ResourceDTO;
import com.SARC.model.ResourceEntity;

@Mapper(uses = {AlocationMapper.class})
public interface ResourceMapper {
    ResourceDTO toDTO(ResourceEntity resourceEntity);
    ResourceEntity toEntity(ResourceDTO resourceDTO);
} 