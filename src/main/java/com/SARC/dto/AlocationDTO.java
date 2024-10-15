package com.SARC.dto;
import com.SARC.model.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlocationDTO {
    private int alocationId;
    private LocalDate dateAlocation;
    private ClassEntity classes;
}
