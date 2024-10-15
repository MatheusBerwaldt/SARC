package com.SARC.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disciplines")
public class DisciplineEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codDiscipline;

    @Column(name = "name_discipline")
    private String nameDiscipline;
    
    @Column(name = "workload")
    private int workload;

    @OneToMany
    private List<ClassEntity> classes;
}
