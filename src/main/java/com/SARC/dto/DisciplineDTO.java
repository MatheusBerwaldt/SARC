package com.SARC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    private int codDiscipline;
    private String nameDiscipline;
    private int workload;
}
