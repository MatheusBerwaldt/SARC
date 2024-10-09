package com.SARC.model;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class AlocationEntity{

    @Column(name = "date_alocation", columnDefinition = "DATE")
    private LocalDate dateAlocation;

    public LocalDate getDateAlocation() {
        return dateAlocation;
    }

    public void setDateAlocation(LocalDate dateAlocation) {
        this.dateAlocation = dateAlocation;
    }

}
