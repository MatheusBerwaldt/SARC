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
    private int codClass;

    @Column(name = "time_class")
    private String timeClass;

    public int getCodClass() {
        return codClass;
    }

    public void setCodClass(int codClass) {
        this.codClass = codClass;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }

}
