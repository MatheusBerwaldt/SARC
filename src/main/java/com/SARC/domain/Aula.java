package com.SARC.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "horario")
    private String horario;

    @ManyToOne
    @JoinColumn(name = "turma_id", referencedColumnName = "codigo")
    private Turma turma;
}

