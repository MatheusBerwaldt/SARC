package com.SARC.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClassRoom;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    @Column(nullable = false)
    private TimeEntityEnum time;

    @Column(nullable = false)
    private DaysEntityEnum days;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity classe;

    @OneToMany
    private List<AlocationEntity> alocation;
}
