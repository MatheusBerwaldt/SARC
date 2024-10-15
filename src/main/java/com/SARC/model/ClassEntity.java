package com.SARC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "classes")
public class ClassEntity {

    @Id
    @Column(name = "id_class")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClass;

    @NotNull
    @Column(name = "time_class")
    private String timeClass;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "professorId")
    private ProfessorEntity professor;

    public Long getIdClass() {
        return idClass;
    }

    public void setIdClass(Long idClass) {
        this.idClass = idClass;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }
    
    public ProfessorEntity getProfessor() {
        return professor;
    }
}
