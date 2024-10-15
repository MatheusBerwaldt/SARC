package com.SARC.dto;

import com.SARC.model.ProfessorEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {
    private String timeClass;
    private ProfessorEntity professor;
}
