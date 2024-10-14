package com.SARC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "class")
public class ClassEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdClass;

    @Column(name = "time_class")
    private String timeClass;

    @Column(name = "professor_id")
    private ProfessorEntity professor;

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public int getIdClass() {
        return IdClass;
    }

    public void setCodClass(int codClass) {
        this.IdClass = codClass;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }

}
