package com.SARC.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class Alocation extends Class{
    
    @Getter
    @Setter
    @Column(name = "date_alocation", columnDefinition = "DATE")
    private LocalDate dateAlocation;

}
