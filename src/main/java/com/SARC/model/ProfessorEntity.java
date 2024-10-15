package com.SARC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.Column;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professors")
public class ProfessorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long professorId;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;
}
