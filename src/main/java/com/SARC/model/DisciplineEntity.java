package com.SARC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "discipline")
public class DisciplineEntity {
    
    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codDiscipline;

    @Column(name = "name_discipline")
    private String nameDiscipline;
    
    @Column(name = "workload")
    private int workload;

    public int getCodDiscipline() {
        return codDiscipline;
    }

    public void setCodDiscipline(int codDiscipline) {
        this.codDiscipline = codDiscipline;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

}
