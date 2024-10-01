package com.SARC.model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class Discipline {
    
    @Id
    @ManyToOne
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codDiscipline;

    @Getter
    @Setter
    @Column(name = "name_discipline")
    private String nameDiscipline;


    @Getter
    @Setter
    @Column(name = "workload")
    private int workload;

}
