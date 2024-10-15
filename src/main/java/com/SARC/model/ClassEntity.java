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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
