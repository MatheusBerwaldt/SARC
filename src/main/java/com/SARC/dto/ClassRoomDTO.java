package com.SARC.dto;

import java.time.LocalDate;
import java.util.List;

import com.SARC.model.AlocationEntity;
import com.SARC.model.ClassEntity;
import com.SARC.model.DaysEntityEnum;
import com.SARC.model.TimeEntityEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDTO {
    private long idClassRoom;
    private LocalDate date;
    private TimeEntityEnum time;
    private DaysEntityEnum days;
    private ClassEntity classe;
    private List<AlocationEntity> alocation;
}
