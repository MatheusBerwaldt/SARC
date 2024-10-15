package com.SARC.model;
import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "alocations")
public class AlocationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alocationId;
    @Column(name = "date_alocation", columnDefinition = "DATE")
    private LocalDate dateAlocation;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity classA;


    public ClassEntity getClassA() {
        return classA;
    }

    public void setClassA(ClassEntity classA) {
        this.classA = classA;
    }
    public LocalDate getDateAlocation() {
        return dateAlocation;
    }

    public void setDateAlocation(LocalDate dateAlocation) {
        this.dateAlocation = dateAlocation;
    }

}
