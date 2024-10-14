package com.SARC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class ClassEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private long IdClass;

    @Column(name = "time_class")
    private String timeClass;
    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "professorId")
    private ProfessorEntity professor;

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public long getIdClass() {
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
