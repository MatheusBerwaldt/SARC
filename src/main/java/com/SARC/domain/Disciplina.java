package com.SARC.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {

    @Id
    private String codigo;
    private String nome;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
}

